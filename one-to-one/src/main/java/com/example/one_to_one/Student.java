package com.example.one_to_one;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentRoll;
    private String studentName;
    private  String studentEmail;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Address_id")
    private Address address;
}