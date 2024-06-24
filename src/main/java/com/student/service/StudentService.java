package com.student.service;

import com.student.exception.ResourceAlreadySavedException;
import com.student.exception.ResourceNotFoundException;
import com.student.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();

    Student getStudentById(Long id) throws ResourceNotFoundException;

    Student createStudent(Student student) throws ResourceAlreadySavedException;

    Student updateStudent(Student student) throws ResourceNotFoundException;

    void deleteStudent(Long id);

    List<Student> addAll(List<Student> newStudents);

    void clearAll();
}
