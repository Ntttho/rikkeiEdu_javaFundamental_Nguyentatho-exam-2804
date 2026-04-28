package com.reptithcm.edu.service;

import com.reptithcm.edu.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStudentService {
    List<Student> getAllStudents();
    Student getById(int id);
    Student create(Student student);
    boolean update(Student student);
    boolean delete(int id);
    List<Student> searchByName(String name);
    List<Student> getSortedStudents();
}
