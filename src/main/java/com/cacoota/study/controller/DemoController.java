package com.cacoota.study.controller;


import com.cacoota.study.model.mybatis.Demo;
import com.cacoota.study.model.mybatis.DemoExample;
import com.cacoota.study.service.mybatis.DemoService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService service;

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public String index(@PathVariable String id) {
        return id;
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public PageInfo<Demo> list(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum, @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        PageInfo<Demo> result = service.selectPageHelper(new DemoExample(), pageNum, pageSize);
        log.info("demo/list-->查询结果：" + result.getSize());
        return result;
    }

    @PostMapping("/demos")
    @ResponseStatus(HttpStatus.CREATED)
    public Object insert(@RequestBody Demo demo) {
        return service.insert(demo);
    }

    @PatchMapping("/demos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object update(@PathVariable("id") String id, @RequestBody Demo demo) {
        DemoExample example = new DemoExample();
        example.createCriteria().andIdEqualTo(Long.valueOf(id));
        return service.update(demo, example);
    }

    @PutMapping("/demos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object modify(@PathVariable("id") String id, @RequestBody Demo demo) {
        DemoExample example = new DemoExample();
        example.createCriteria().andIdEqualTo(Long.valueOf(id));
        return service.update(demo, example);
    }

    @DeleteMapping(value = "/demos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        DemoExample example = new DemoExample();
        example.createCriteria().andIdEqualTo(Long.valueOf(id));
        service.delete(example);
    }


    @Autowired
    private StringEncryptor encryptor;

    @GetMapping("/encode/{code}")
    @ResponseStatus(HttpStatus.OK)
    public String encoder(@PathVariable String code) {
        System.out.println(encryptor.decrypt("Zh7VU8krZ6CiSZqebuO6sFY//G413yX0sPhqZKAIqvrvLA1jcwr8+m+uUaVIUbmzVhbnpOIQjUbD1A0/xFqFBTrMFRZ76b+6uX/ZpaxqLfC8SXtpDL0aO6AfWdOWH92b"));
        return encryptor.encrypt(code);
    }

}
