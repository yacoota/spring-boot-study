package com.cacoota.framework.base.controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;

/**
 * 添加类/接口功能描述。
 *
 * @author WYC
 */
public abstract class BaseController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        // binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


}
