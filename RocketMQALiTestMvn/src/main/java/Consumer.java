import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author Adong
 */
public class Consumer {
    public static void main(String[] args) throws MQClientException {
        // push模式 指定消费者组
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("adongConsumer");
        // 指定 nameServer 的地址
        consumer.setNamesrvAddr("127.0.0.1:9876");
        // 订阅主题
        consumer.subscribe("adongTopic", "*");
        // 注册消息监听器
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt messageExt : list) {
                    System.out.printf("消费信息：%s", new String(messageExt.getBody()) + "\n");
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        // 启动
        consumer.start();

        System.out.printf("Consumer Started %n");

    }

}
