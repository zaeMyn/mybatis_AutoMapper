package com.zzm.mapper;

import com.zzm.model.AssertEntity;
import com.zzm.model.AssertEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AssertEntityMapper {
    long countByExample(AssertEntityExample example);

    int deleteByExample(AssertEntityExample example);

    int deleteByPrimaryKey(String id);

    int insert(AssertEntity record);

    int insertSelective(AssertEntity record);

    List<AssertEntity> selectByExample(AssertEntityExample example);

    AssertEntity selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AssertEntity record, @Param("example") AssertEntityExample example);

    int updateByExample(@Param("record") AssertEntity record, @Param("example") AssertEntityExample example);

    int updateByPrimaryKeySelective(AssertEntity record);

    int updateByPrimaryKey(AssertEntity record);
}