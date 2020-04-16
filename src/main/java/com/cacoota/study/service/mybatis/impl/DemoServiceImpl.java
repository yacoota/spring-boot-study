package com.cacoota.study.service.mybatis.impl;


import com.cacoota.study.mapper.mybatis.DemoMapper;
import com.cacoota.study.model.mybatis.Demo;
import com.cacoota.study.model.mybatis.DemoExample;
import com.cacoota.study.service.mybatis.DemoService;
import com.cacoota.framework.base.service.impl.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class DemoServiceImpl extends BaseServiceImpl<Demo, DemoExample> implements DemoService {

    @Autowired
    private DemoMapper mapper;

    @Override
    protected void setBaseMapper() {
        super.mapper = mapper;
    }

    @Override
    public PageInfo<Demo> selectPageHelper(DemoExample example, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo(mapper.selectByExampleWithBLOBs(example));
    }

    @Override
    @Transactional
    public int insert(Demo demo) {
        return super.insert(demo);
    }

}
