package com.mqtt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/run")
public class TestsController {

    @Autowired
    private Listener service;

    @GetMapping()
    public void init() {
        service.init();
    }
}
