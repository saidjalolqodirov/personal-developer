package com.example.dynamicfilter.lazy_initialization;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {
    private final SchoolRepository schoolRepository;
    private final StudentRepository studentRepository;

    public SchoolController(SchoolRepository schoolRepository, StudentRepository studentRepository) {
        this.schoolRepository = schoolRepository;
        this.studentRepository = studentRepository;
    }

    @PostMapping("/create")
    public void create(@RequestBody SchoolRequestDto requestDto) {
        requestDtoToModel(requestDto, new School());
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Integer id, @RequestBody SchoolRequestDto requestDto) {
        requestDtoToModel(requestDto, schoolRepository.getOne(id));
    }

    private void requestDtoToModel(SchoolRequestDto requestDto, School school) {
        school.setName(requestDto.getName());
        List<Students> list = new ArrayList<>();
        for (StudentRequest student : requestDto.getStudents()) {
            Students students;
            if (student.getId() == null) {
                students = new Students();
            } else students = studentRepository.findById(student.getId()).get();
            students.setName(student.getName());
            list.add(students);
        }
        school.setStudents(list);
        schoolRepository.save(school);
    }
}
