package com.cacoota.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/study")
public class StudyController {

    @RequestMapping(value = {"", "/", "/index"})
    public String index() {
        return "hi, spring boot study.";
    }
}
