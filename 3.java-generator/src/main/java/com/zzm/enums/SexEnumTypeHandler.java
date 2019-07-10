package com.zzm.enums;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * @author zhengzm
 * @date 2019/7/10 10:13
 * @description
 */
public class SexEnumTypeHandler extends BaseTypeHandler<SexEnum> {

    /**
     * 用于定义设置参数时，该如何把Java类型的参数转换为对应的数据库类型
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, SexEnum parameter, JdbcType jdbcType)
            throws SQLException {
        // baseTypeHandler已经帮我们做了parameter的null判断
        // 第二个参数 : 存入到数据库中的值
        ps.setString(i, parameter.getKey());
    }

    /**
     * 用于定义通过字段名称获取字段数据时，如何把数据库类型转换为对应的Java类型
     */
    @Override
    public SexEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {

        System.out.println("columnName执行我");

        // 根据数据库存储类型决定获取类型，本例子中数据库中存放String类型
        String key = rs.getString(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的key值，定位SexEnum子类
            return SexEnum.getSexEnumByKey(key);
        }
    }

    /**
     * 用于定义通过字段索引获取字段数据时，如何把数据库类型转换为对应的Java类型
     */
    @Override
    public SexEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {

        System.out.println("columnIndex执行我");

        // 根据数据库存储类型决定获取类型，本例子中数据库中存放String类型
        String key = rs.getString(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的key值，定位SexEnum子类
            return SexEnum.getSexEnumByKey(key);
        }
    }

    /**
     * 用定义调用存储过程后，如何把数据库类型转换为对应的Java类型
     */
    @Override
    public SexEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        // 根据数据库存储类型决定获取类型，本例子中数据库中存放String类型
        String key = cs.getString(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的key值，定位SexEnum子类
            return SexEnum.getSexEnumByKey(key);
        }
    }

}
