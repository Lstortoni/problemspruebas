package com.citycode.problemservice.controller;

import com.citycode.problemservice.dto.ProblemDTO;
import com.citycode.problemservice.exception.HIbernateOperationException;
import com.citycode.problemservice.exception.IdNotFoundException;
import com.citycode.problemservice.service.IProblemService;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/problems")

public class ProblemController {
    @Autowired
    private IProblemService problemServ;


    @GetMapping("/all")
    public List<ProblemDTO> getAll(){

        return problemServ.getProblems();
    }

    @GetMapping("/{id_problem}")
    public ProblemDTO getProblemById(@PathVariable Long id_problem)throws IdNotFoundException {

        return problemServ.getProblemById(id_problem);
    }
    @GetMapping("/saludo")
    @Operation(summary = "Obtener Saludo", description = "Obtiene un saludo de ejemplo")

    @PostMapping("/save")
    public ProblemDTO saveProblem(@RequestBody ProblemDTO problem) throws HIbernateOperationException {

        return problemServ.saveProblem(problem);
    }

}
