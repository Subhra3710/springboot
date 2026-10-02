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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String studentName;
    private String studentEmail;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name="students_subjects",
            joinColumns = @JoinColumn(name ="student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")

    )
    private List<Subject> subjects;

}
