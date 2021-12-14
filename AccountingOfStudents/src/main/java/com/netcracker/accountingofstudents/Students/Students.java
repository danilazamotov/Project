package com.netcracker.accountingofstudents.Students;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Builder

@Table("students")
public class Students {

    @Id
    private Integer id_name;
    @Column("fullname")
    private String fullName;
    private String group;

    public Students(String name) {
//        this.id_name = id_name;
        this.fullName = name;
    }
}
