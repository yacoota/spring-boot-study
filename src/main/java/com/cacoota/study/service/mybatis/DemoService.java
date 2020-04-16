package com.cacoota.study.service.mybatis;


import com.cacoota.study.model.mybatis.Demo;
import com.cacoota.study.model.mybatis.DemoExample;
import com.cacoota.framework.base.service.BaseService;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DemoService extends BaseService<Demo, DemoExample> {

    List<Demo> select(DemoExample example);

    PageInfo<Demo> selectPageHelper(DemoExample example, int pageNum, int pageSize);

}
