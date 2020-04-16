package com.cacoota.study.service;


import com.cacoota.study.model.Demo;
import com.cacoota.study.model.DemoExample;
import com.cacoota.core.base.service.BaseService;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DemoService extends BaseService<Demo, DemoExample> {

    List<Demo> select(DemoExample example);

    PageInfo<Demo> selectPageHelper(DemoExample example, int pageNum, int pageSize);

}
