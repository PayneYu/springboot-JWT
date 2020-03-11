package com.payne.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Supply Center
 * @description:
 * @author: Huizhe Yu
 * @create: 2019-11-21 15:46
 */
@RestController
public class SendMessageController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private String topic = "test-topic";

    @GetMapping("/send")
    public String send(String params) {
        System.out.println("[ 收到请求 ]");

        kafkaTemplate.send(topic, params);

        System.out.println("[ 返回响应 ]");
        return "您的任务已提交";
    }
}
