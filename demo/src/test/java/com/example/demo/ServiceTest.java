package com.example.demo;

import com.example.demo.domain.Girl;
import com.example.demo.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ZL
 * @date 2018/6/14 20:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class ServiceTest {
    @Autowired
    private GirlService girlService;

    @Test
    public void findITest() {
        Girl girl =girlService.findI(3);
        Assert.assertEquals(new Integer(12),girl.getAge());
    }
}

