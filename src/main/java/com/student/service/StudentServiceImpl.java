package com.student.service;

import com.student.exception.ResourceNotFoundException;
import com.student.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private List<Student> studentList = new ArrayList<>();

    @Override
    public List<Student> getAll() {
        return studentList;
    }

    @Override
    public Student getStudentById(Long id) throws ResourceNotFoundException {
        Student student = find(id);
        if (student != null) {
            return student;
        }
        throw new ResourceNotFoundException(id + " is not found", "student-service");
    }

    @Override
    public Student saveStudent(Student student) throws ResourceNotFoundException {
        Student found = find(student.getId());
        if (found == null) {
            studentList.add(student);
        } else {
            found.setName(student.getName());
            found.setGrade(student.getGrade());
        }
        return student;
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = find(id);
        if (student == null) {
            throw new ResourceNotFoundException(id + " is not found", "student-service");
        } else {
            studentList.remove(student);
        }
    }

    private Student find(Long id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
