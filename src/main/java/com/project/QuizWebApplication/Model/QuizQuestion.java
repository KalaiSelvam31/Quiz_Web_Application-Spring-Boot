package com.project.QuizWebApplication.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Entity
@Table(name = "quiz_question")
public class QuizQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quizId;
    private String questionText;
    private String option_A;
    private String option_B;
    private String option_C;
    private String option_D;
    private String correctAnswer;
    private String category;
}
