package com.netcracker.accountingofstudents.Students.Repository;

import com.netcracker.accountingofstudents.Students.Students;
import org.springframework.data.repository.CrudRepository;

public interface SubjectGrades extends CrudRepository<Students, Integer> {

}
