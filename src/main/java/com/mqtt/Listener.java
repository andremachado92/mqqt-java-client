package com.mqtt;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
@Slf4j
@Service
public class Listener implements IMqttMessageListener {

    @Autowired
    private MqttProperties mqttProperties;

    @PostConstruct
    public void init() {

        try {
            var sampleClient = new MqttClient(mqttProperties.getBroker(), mqttProperties.getClientId(),new MemoryPersistence());
            var connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            connOpts.setUserName(mqttProperties.getUserName());
            connOpts.setPassword(mqttProperties.getPassword().toCharArray());
            System.out.println("Connecting to broker: " + mqttProperties.getBroker());
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            sampleClient.subscribe(mqttProperties.getTopic(), mqttProperties.getQos(), this);
        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }

    @Override
    public void messageArrived(String topico, MqttMessage mm) throws Exception {
        System.out.println("Mensagem recebida:");
        System.out.println("\tTópico: " + topico);
        System.out.println("\tMensagem: " + new String(mm.getPayload()));
        System.out.println("");
    }
}
                                                                                                                                                