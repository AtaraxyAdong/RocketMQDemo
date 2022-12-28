import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @author Adong
 */
public class Producer {

    public static void main(String[] args) throws Exception {
        // 创建一个生产者，生产组是 adongProducer
        DefaultMQProducer producer = new DefaultMQProducer("adongProducer");
        // 设置 nameServer 的地址
        producer.setNamesrvAddr("127.0.0.1:9876");
        // 第一次连接需要的时间比较久
        producer.setSendMsgTimeout(6000);
        // 启动
        producer.start();
        // 配置发送的消息
        Message message = new Message("adongTopic", "TagA", "adong test message".getBytes(RemotingHelper.DEFAULT_CHARSET));
        // 发送消息返回发送结果
        SendResult sendResult = producer.send(message);
        System.out.printf("%s%n", sendResult);
        // 关闭生产者
        producer.shutdown();
    }
}
