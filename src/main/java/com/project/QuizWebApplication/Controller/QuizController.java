package com.project.QuizWebApplication.Controller;

import com.project.QuizWebApplication.Model.Contest;
import com.project.QuizWebApplication.Model.QuestionWrapper;
import com.project.QuizWebApplication.Model.QuizQuestion;
import com.project.QuizWebApplication.Model.Response;
import com.project.QuizWebApplication.Services.ContestService;
import com.project.QuizWebApplication.Services.QuizServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class QuizController {

    @Autowired
    QuizServices quizServices;
    @Autowired
    ContestService contest;

    @GetMapping("/quiz/allquestion")
    public ResponseEntity<List<QuizQuestion>> getAllQuestion() {
        return quizServices.getAllQuestion();

    }

    @GetMapping("/quiz/allQuestionById/{quiz_id}")
    public ResponseEntity<List<QuizQuestion>> getAllQuestionById(@PathVariable("quiz_id") int quiz_id) {
        return quizServices.getAllQuestionById(quiz_id);
    }

    @GetMapping("/quiz/allQuestionByCategory/{category}")
    public ResponseEntity<List<QuizQuestion>> getAllQuestionById(@PathVariable("category") String category) {
        return quizServices.getAllQuestionByCategory(category);
    }

    @PostMapping("/quiz/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody QuizQuestion questions) {
        if (quizServices.addQuestion(questions))
            return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
        else
            return new ResponseEntity<>("Added Failed", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/quiz/createQuiz/")
    public ResponseEntity<String> createQuiz(@RequestParam("category") String category, @RequestParam("No.Question") int number, @RequestParam("Tile") String practise) {
        return contest.createQuiz(category, number, practise);
    }

    @GetMapping("quiz/get/{id}")
    public  ResponseEntity<List<QuestionWrapper >>getQuiz(@PathVariable int id){
        return  contest.getQuiz( id);
    }
    @PostMapping("quiz/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id , @RequestBody List<Response> responses){
        return contest.calculateResult(id,responses);
    }
    @GetMapping("/quiz/all-contests")
    public ResponseEntity<List<Contest>> getAllContests() {
        return contest.getAllContests();
    }


}
