package com.project.QuizWebApplication.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Contest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO  )
    private int id;

    private String title;

    @ManyToMany
    private List<QuizQuestion> test;
}
