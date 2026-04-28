package com.reptithcm.edu.controller;

import com.reptithcm.edu.entity.Student;
import com.reptithcm.edu.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Qualifier("studentServiceImpl")
    @Autowired
    private IStudentService studentService;

    @GetMapping
    public String getStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

//    @GetMapping("/details/{id}")
//    public String getStudentDetails(Model model, @PathVariable("id") int id){
//        Student student = studentService.getById(id);
//        if (student != null) {
//            model.addAttribute("s", student); // Đẩy đối tượng sinh viên vào biến 's'
//            return "student-details"; // Trả về file student-detail.html
//        }
//        return "redirect:/students"; // Nếu không thấy thì quay về danh sách        return "student-details";
//    }

    @GetMapping("/details/{id}/form-update")
    public String getFormUpdate(Model model, @PathVariable("id") int id){
        model.addAttribute("student", studentService.getById(id));
        return "form-update";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(
            @PathVariable("id") int id, @ModelAttribute("student") Student student
    ){
        studentService.update(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        // 1. Gọi service để xóa
        boolean isDeleted = studentService.delete(id);
        return "redirect:/students";
    }

    @GetMapping("/create")
    public String createStudent(Model model){
        model.addAttribute("student", new Student());
        return "form-create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute("student") Student student){
        studentService.create(student);
        return "redirect:/students";
    }
}
