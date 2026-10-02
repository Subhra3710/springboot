package com.example.Many_To_Many;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Builder
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjectId;

    private String subjectName;

    @ManyToMany(mappedBy = "subjects", fetch = FetchType.EAGER)
    private List<Student> students;
}
