package com.example.rocketmqalitest;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = RocketMqaLiTestApplication.class)
@RunWith(SpringRunner.class)
class RocketMqaLiTestApplicationTests {

    @Autowired
    private RocketMQTemplate template;

    @Test
    public void send() throws InterruptedException {
        template.convertAndSend("adongTopic", "Hello, RocketMQ!");
        Thread.sleep(60000);
    }

}
