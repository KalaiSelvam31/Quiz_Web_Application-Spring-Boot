package com.project.QuizWebApplication.Services;

import com.project.QuizWebApplication.Model.Contest;
import com.project.QuizWebApplication.Model.QuestionWrapper;
import com.project.QuizWebApplication.Model.QuizQuestion;
import com.project.QuizWebApplication.Model.Response;
import com.project.QuizWebApplication.Respository.ContestRepo;
import com.project.QuizWebApplication.Respository.QuestionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ContestService {

    @Autowired
    ContestRepo contest;
    @Autowired
    QuestionsRepo questionsRepo;


    public ResponseEntity<String> createQuiz(String category, int number, String practise) {
        Contest c = new Contest();

        c.setTitle(practise);
        List<QuizQuestion> test=questionsRepo.fetchRandom(category,number);
        c.setTest(test);
        contest.save(c);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(int id) {
        Optional<Contest> con =contest.findById(id);
        List<QuizQuestion> questionfromDB= con.get().getTest();
        List<QuestionWrapper> questionforUser=new ArrayList<>();
        for(QuizQuestion q:questionfromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionText(),q.getOption_A(),q.getOption_B(),q.getOption_C(),q.getOption_D());
            questionforUser.add(qw);
        }
        return new ResponseEntity<>(questionforUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {
        Contest con = contest.findById(id).orElseThrow(() -> new RuntimeException("Contest not found"));
        List<QuizQuestion> questionList = con.getTest();

        int right = 0;

        for (int i = 0; i < responses.size(); i++) {
            String userAnswer = responses.get(i).getCorrect_answer();
            String correctAnswer = questionList.get(i).getCorrectAnswer();

            if (userAnswer != null && userAnswer.equals(correctAnswer)) {
                right++;
            }
        }

        return new ResponseEntity<>(right, HttpStatus.OK);
    }

    public ResponseEntity<List<Contest>> getAllContests() {
        return new ResponseEntity<>(contest.findAll(), HttpStatus.OK);
    }
}
