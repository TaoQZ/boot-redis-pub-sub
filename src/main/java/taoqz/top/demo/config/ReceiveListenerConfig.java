package taoqz.top.demo.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import taoqz.top.demo.listen.ReceiveListener_topic1;
import taoqz.top.demo.listen.ReceiveListener_topic2;

@Configuration
public class ReceiveListenerConfig extends CachingConfigurerSupport {


    /**
     * 消息监听容器
     *
     * @param factory
     * @return
     */
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory factory){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(factory);
        //订阅一个通道 该处的通道名是发布消息时的名称
        container.addMessageListener(catAdapter1(),new PatternTopic("topic1"));
        return container;
    }

    @Bean
    RedisMessageListenerContainer container2(RedisConnectionFactory factory){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(factory);
        //订阅一个通道 该处的通道名是发布消息时的名称
        container.addMessageListener(catAdapter2(),new PatternTopic("topic2"));
        return container;
    }

    /**
     * 消息监听适配器，绑定消息处理器
     *
     * @return
     */
    @Bean
    MessageListenerAdapter catAdapter1(){
        return new MessageListenerAdapter(new ReceiveListener_topic1());
    }

    @Bean
    MessageListenerAdapter catAdapter2(){
        return new MessageListenerAdapter(new ReceiveListener_topic2());
    }


}
