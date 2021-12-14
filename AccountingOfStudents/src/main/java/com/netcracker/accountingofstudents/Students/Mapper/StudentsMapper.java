package com.netcracker.accountingofstudents.Students.Mapper;

import com.netcracker.accountingofstudents.Students.Students;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentsMapper implements RowMapper <Students> {

    @Override
    public Students mapRow(ResultSet rs, int i) throws SQLException {
        return Students.builder().
                id_name(rs.getInt(1)).
                fullName(rs.getString(2)).
                group(rs.getString(3)).
                build();

    }
}
