package com.project.QuizWebApplication.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class QuestionWrapper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String questionText;
    private String option_A;
    private String option_B;
    private String option_C;
    private String option_D;

    public QuestionWrapper(int id, String questionText, String option_A, String option_B, String option_C, String option_D) {
        this.id = id;
        this.questionText = questionText;
        this.option_A = option_A;
        this.option_B = option_B;
        this.option_C = option_C;
        this.option_D = option_D;
    }
}
