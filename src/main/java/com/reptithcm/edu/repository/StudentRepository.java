package com.reptithcm.edu.repository;

import com.reptithcm.edu.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private static List<Student> students = new ArrayList<>();
    private boolean search = false;

    static {
        students.add(new Student(1, "SV01", "Nguyen ta tho", "nguyentho141@gmail.com", "Kinh te", 8.7));
        students.add(new Student(2, "SV02", "Nguyen ta tho", "nguyentho141@gmail.com", "Kinh te", 8.7));
        students.add(new Student(3, "SV03", "Nguyen ta tho", "nguyentho141@gmail.com", "Kinh te", 8.7));
        students.add(new Student(4, "SV04", "Nguyen ta tho", "nguyentho141@gmail.com", "Kinh te", 8.7));
        students.add(new Student(5, "SV05", "Nguyen ta tho", "nguyentho141@gmail.com", "Kinh te", 8.7));
    }

    public List<Student> getStudents(){
        return students;
    }

    public Student getStudentById(int id){
        return students.stream().filter(s -> s.getId() == id).findFirst().orElseGet(null);
    }

    public boolean updateStudent(Student student){

        Student studentUpdate = getStudentById(student.getId());
        if(studentUpdate == null){
            return false;
        }
        if(!student.getStudentCode().isEmpty())
            studentUpdate.setStudentCode(student.getStudentCode());
        if(!student.getEmail().isEmpty())
            studentUpdate.setEmail(student.getEmail());
        if(student.getGpa() >= 0 && student.getGpa() <= 10)
            studentUpdate.setGpa(student.getGpa());
        if(!student.getMajor().isEmpty())
            studentUpdate.setMajor(student.getMajor());
        if(!student.getFullName().isEmpty())
            studentUpdate.setFullName(student.getFullName());

        return true;
    }

    public Student addStudent(Student student){
        students.add(student);
        return student;
    }

    public boolean deleteStudent(int id){
        return students.removeIf(student -> student.getId() == id);
    }

    public List<Student> searchStudent(String nameSearch){
        return students.stream().filter(student -> student.getFullName().contains(nameSearch)).collect(Collectors.toList());
    }

    public List<Student> sortStudent(List<Student> students){
        return students.stream().sorted().toList();
    }

}
