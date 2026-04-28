package com.reptithcm.edu.service;

import com.reptithcm.edu.entity.Student;
import com.reptithcm.edu.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getStudents();
    }

    @Override
    public Student getById(int id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public Student create(Student student) {
        // Bạn có thể thêm logic kiểm tra trùng lặp mã sinh viên ở đây
        return studentRepository.addStudent(student);
    }

    @Override
    public boolean update(Student student) {
        return studentRepository.updateStudent(student);
    }

    @Override
    public boolean delete(int id) {
        return studentRepository.deleteStudent(id);
    }

    @Override
    public List<Student> searchByName(String name) {
        if (name == null || name.isEmpty()) {
            return studentRepository.getStudents();
        }
        return studentRepository.searchStudent(name);
    }

    @Override
    public List<Student> getSortedStudents() {
        List<Student> currentList = studentRepository.getStudents();
        return studentRepository.sortStudent(currentList);
    }
}