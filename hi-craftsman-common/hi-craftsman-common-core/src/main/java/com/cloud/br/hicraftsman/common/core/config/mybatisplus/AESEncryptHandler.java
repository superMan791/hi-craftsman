package com.cloud.br.hicraftsman.common.core.config.mybatisplus;

import com.baomidou.mybatisplus.core.toolkit.AES;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * mybatis 数据加密
 * @author yzp
 * @date 2021/1/27 10:07
 */
public class AESEncryptHandler extends BaseTypeHandler {
    //加盐
    public static String key = "da60060d105b80e3";

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, AES.encrypt((String) parameter, key));
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String columnValue = rs.getString(columnName);
        return AES.decrypt(columnValue, key);
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String columnValue = rs.getString(columnIndex);
        return AES.decrypt(columnValue, key);
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        String columnValue = cs.getString(columnIndex);
        return AES.decrypt(columnValue, key);
    }

}