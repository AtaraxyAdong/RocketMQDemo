package com.example.rocketmqalitest.mqtt;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;


/**
 * @author Adong
 */
@Component
@RocketMQMessageListener(consumerGroup = "adongConsumer", topic = "adongTopic")
public class AdongTopicListener implements RocketMQListener {

    @Override
    public void onMessage(Object msg) {
        System.out.println("处理消息:" + msg);
    }

}
