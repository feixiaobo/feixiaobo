package exercise;

import exercise.redisManage.TestSubScriber;
import exercise.service.RedisPubService;
import exercise.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by feixiaobo on 2016/11/29.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class redisTest {

    @Autowired
    private RedisService redisService;
    @Autowired
    private TestSubScriber testSubScrtbe;
    @Autowired
    private RedisPubService redisPubService;

    @Test
    public void testRedis(){
        redisService.setObject("test","value",null);
        String value = redisService.getObject("identify_code_register:13521837263");
        System.out.println("++++++++++++"+value);
    }

    @Test
    public void testRedisPub(){
        redisPubService.publishMessage(testSubScrtbe,"test");
    }
}
