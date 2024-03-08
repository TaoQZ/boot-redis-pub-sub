package taoqz.top.demo.listen;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveListener_topic2 implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] bytes) {
        System.out.println();
        System.out.println("我是监听者小B,我监听到的消息是 " +  message.toString());
    }

}

