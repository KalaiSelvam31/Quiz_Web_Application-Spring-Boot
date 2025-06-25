package com.project.QuizWebApplication.Services;

import com.project.QuizWebApplication.Model.QuizQuestion;
import com.project.QuizWebApplication.Respository.QuestionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;


@Service
public class QuizServices {


    @Autowired
    public QuestionsRepo questions;

    public ResponseEntity<List<QuizQuestion>> getAllQuestion() {
        try {
            return new ResponseEntity<>(questions.findAll(),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();

        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<QuizQuestion>> getAllQuestionById(int quiz_id) {
        List<QuizQuestion> dummy = questions.findByQuizId(quiz_id);
        return dummy.isEmpty() ? new ResponseEntity<>( new ArrayList<>(), HttpStatus.BAD_REQUEST) : new ResponseEntity<>(dummy,HttpStatus.OK);
    }

    public ResponseEntity<List<QuizQuestion>> getAllQuestionByCategory(String category) {
        List<QuizQuestion> dummy = questions.findBycategory(category);
        return dummy.isEmpty() ? new ResponseEntity<>( new ArrayList<>(), HttpStatus.BAD_REQUEST) : new ResponseEntity<>(dummy,HttpStatus.OK);
    }

    public boolean addQuestion(QuizQuestion question) {
        questions.save(question);
        return true;
    }



}
