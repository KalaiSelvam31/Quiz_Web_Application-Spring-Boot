package com.project.QuizWebApplication.Respository;

import com.project.QuizWebApplication.Model.Contest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContestRepo extends JpaRepository<Contest,Integer> {

}
