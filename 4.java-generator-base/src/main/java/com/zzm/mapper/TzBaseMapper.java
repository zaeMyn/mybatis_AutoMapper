package com.zzm.mapper;

import com.zzm.mapper.extmapper.ExtTzBaseMapper;
import com.zzm.model.TzBase;
import com.zzm.model.TzBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface TzBaseMapper extends ExtTzBaseMapper {
}