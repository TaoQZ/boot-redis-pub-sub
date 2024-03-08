package taoqz.top.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/push/{msg}")
    public void push(@PathVariable String msg) {
        redisTemplate.convertAndSend("topic1",msg );
    }

    @GetMapping("/push2/{msg}")
    public void push2(@PathVariable String msg) {
        redisTemplate.convertAndSend("topic2",msg );
    }

    @GetMapping
    public String ok () {
        return "ok!";
    }

}
