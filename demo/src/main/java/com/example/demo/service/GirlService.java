package com.example.demo.service;

import com.example.demo.domain.Girl;
import com.example.demo.handle.GirlException;
import com.example.demo.reopositry.GirlRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GirlService {
    @Autowired
    private GirlRepositry girlRepositry;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setAge(32);
        girlA.setCupSize("v");
        girlRepositry.save(girlA);
        //int t = 10 / 0;
        Girl girlB = new Girl();
        girlB.setAge(32);
        girlB.setCupSize("v");


        girlRepositry.save(girlB);

    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepositry.findById(id).orElse(null);
        Integer age = girl.getAge();
        if (age < 10) {
            throw new GirlException(100, "小学");
        } else if (age > 10 && age < 16) {
            throw new GirlException(101, "中学");
        }
    }

    public Girl findI(Integer id){
        return girlRepositry.findById(id).orElse(null);
    }
}
