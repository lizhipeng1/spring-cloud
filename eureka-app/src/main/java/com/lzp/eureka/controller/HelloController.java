package com.lzp.eureka.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("hello")
    public String index(){
        ServiceInstance serviceInstance = client.getLocalServiceInstance();
        logger.info( "/hello , host: "+ serviceInstance.getHost()+", service_id: "+serviceInstance.getServiceId());
        return "hello word!";
    }

}
