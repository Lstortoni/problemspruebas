package com.citycode.problemservice.repository;

import com.citycode.problemservice.model.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProblemsRepository extends JpaRepository<Problem, Long> {
}
