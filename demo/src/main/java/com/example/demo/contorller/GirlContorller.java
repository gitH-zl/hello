package com.example.demo.contorller;

import com.example.demo.domain.Result;
import com.example.demo.reopositry.GirlRepositry;
import com.example.demo.service.GirlService;
import com.example.demo.domain.Girl;
import com.example.demo.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class GirlContorller {
    @Autowired
    private GirlRepositry girlRepositry;
    @Autowired
    private GirlService girlService;

    //查询所有的女生列表
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlRepositry.findAll();

    }

    /**
     * 改进版
     *
     * @return
     */
    @PostMapping(value = "/girls1")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return ResultUtils.error(1, bindingResult.getFieldError().getDefaultMessage());

        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return ResultUtils.success(girlRepositry.save(girl));

    }

    //@PostMapping(value = "/girls2")
    public Girl girlAdd2(@RequestParam("cupSize") String cupSize,
                         @RequestParam("age") Integer age) {

        Girl girl = new Girl();
        girl.setCupSize(cupSize);

        girl.setAge(age);
        return girlRepositry.save(girl);
    }

    //@GetMapping(value = "/girls/{id}")
    public Girl selectGirl(@PathVariable(value = "id") Integer id) {

        return girlRepositry.findById(id).orElse(null);
    }

    @PutMapping(value = "/girls/{id}")
    public Girl updateGirl(@PathVariable(value = "id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {

        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepositry.save(girl);
    }

    @DeleteMapping(value = "/girls/{id}")
    public void deletetGirl(@PathVariable(value = "id") Integer id) {

        girlRepositry.deleteById(id);
    }

    @GetMapping(value = "/girls/{age}")
    public List<Girl> findByAge(@PathVariable("age") Integer age) {
        return girlRepositry.findByAge(age);
    }

    @GetMapping(value = "/girls/two")
    public void insertWeo() {
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}

