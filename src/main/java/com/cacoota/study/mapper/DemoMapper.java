package com.cacoota.study.mapper;


import com.cacoota.study.model.Demo;
import com.cacoota.study.model.DemoExample;
import com.cacoota.core.base.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DemoMapper extends BaseMapper<Demo, DemoExample> {

    int countByExample(DemoExample example);

    int deleteByExample(DemoExample example);

    int insert(Demo record);

    int insertSelective(Demo record);

    List<Demo> selectByExampleWithBLOBs(DemoExample example);

    List<Demo> selectByExample(DemoExample example);

    int updateByExampleSelective(@Param("record") Demo record, @Param("example") DemoExample example);

    int updateByExampleWithBLOBs(@Param("record") Demo record, @Param("example") DemoExample example);

    int updateByExample(@Param("record") Demo record, @Param("example") DemoExample example);
}