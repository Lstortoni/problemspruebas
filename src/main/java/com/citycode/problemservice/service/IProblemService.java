package com.citycode.problemservice.service;

import com.citycode.problemservice.dto.ProblemDTO;
import com.citycode.problemservice.exception.HIbernateOperationException;
import com.citycode.problemservice.exception.IdNotFoundException;

import java.util.List;

public interface IProblemService {

    public List<ProblemDTO> getProblems();

    public ProblemDTO getProblemById(Long id_problem) throws IdNotFoundException;

    public ProblemDTO saveProblem (ProblemDTO problem) throws HIbernateOperationException;
}
