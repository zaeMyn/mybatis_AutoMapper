package com.zzm.mapper.extmapper;

import com.zzm.model.TzBase;
import com.zzm.model.TzBaseExample;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhengzm
 * @date 2019/11/22 22:18
 * @description
 */
@Mapper
public interface ExtTzBaseMapper {

  List<TzBase> selectByExample2(TzBaseExample example);

}
