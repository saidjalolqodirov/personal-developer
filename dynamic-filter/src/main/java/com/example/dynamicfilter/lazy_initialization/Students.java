package com.example.dynamicfilter.lazy_initialization;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "school_id", updatable = false, insertable = false)
    @ToString.Exclude
    private School school;

    @Column(name = "school_id")
    private Integer schoolId;
}
