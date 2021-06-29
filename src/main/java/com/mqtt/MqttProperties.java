package com.mqtt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties("mqtt")
public class MqttProperties {

    private String topic;
    private Integer qos;
    private String broker;
    private String clientId;
    private String password;
    private String userName;
}
