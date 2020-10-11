package pl.coderslab.spring01.hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.spring01.hibernate.model.Student;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/form")
    public String getStudentFrom(Model m){
        m.addAttribute("student", new Student());
        return "student/form-student";
    }

    @PostMapping("/form")
    public String getStudentFrom(@ModelAttribute Student student, Model m){
        m.addAttribute("student", student);
        return "student/show-student";
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("skills")
    public List<String> skills() {
        return Arrays.asList("Java", "PHP", "SQL", "Spring", "HTML5");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("Movies", "Video games", "Travel", "Sports", "Programming");
    }
}
