package com.project.QuizWebApplication.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.QuizWebApplication.Model.QuizQuestion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionsRepo extends JpaRepository<QuizQuestion, Integer> {
    List<QuizQuestion> findByQuizId(int quiz_id);
    List<QuizQuestion> findBycategory(String category);

    @Query(value = "select * from quiz_question where category =:category ORDER BY RAND() LIMIT :numLimit",nativeQuery = true)
    List<QuizQuestion> fetchRandom(
            @Param("category") String category,
            @Param("numLimit") int numLimit
    );

}
