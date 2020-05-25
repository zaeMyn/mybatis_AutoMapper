package com.zzm.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;

/**
 * @author: zaemyn
 * @date: 2020/5/25
 */
public class Blob2ByteArrayTypeHandler extends BaseTypeHandler<byte[]> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, byte[] bytes, JdbcType jdbcType) throws SQLException {
        preparedStatement.setBytes(i,bytes);
    }

    @Override
    public byte[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Blob blob = resultSet.getBlob(s);
        return blob.getBytes(1, (int)blob.length());
    }

    @Override
    public byte[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        Blob blob = resultSet.getBlob(i);
        return blob.getBytes(1, (int)blob.length());
    }

    @Override
    public byte[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        Blob blob = callableStatement.getBlob(i);
        return blob.getBytes(1, (int)blob.length());
    }
}
