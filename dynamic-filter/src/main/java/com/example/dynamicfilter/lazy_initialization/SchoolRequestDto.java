package com.example.dynamicfilter.lazy_initialization;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SchoolRequestDto {
    private String name;
    private List<StudentRequest> students;
}
