package com.zzm.dal.mapper;

import com.zzm.dal.domain.AssetEntity;
import com.zzm.dal.domain.AssetEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AssetEntityMapper {
    long countByExample(AssetEntityExample example);

    int deleteByExample(AssetEntityExample example);

    int deleteByPrimaryKey(String id);

    int insert(AssetEntity record);

    int insertSelective(AssetEntity record);

    List<AssetEntity> selectByExampleWithRowbounds(AssetEntityExample example, RowBounds rowBounds);

    List<AssetEntity> selectByExample(AssetEntityExample example);

    AssetEntity selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AssetEntity record, @Param("example") AssetEntityExample example);

    int updateByExample(@Param("record") AssetEntity record, @Param("example") AssetEntityExample example);

    int updateByPrimaryKeySelective(AssetEntity record);

    int updateByPrimaryKey(AssetEntity record);
}