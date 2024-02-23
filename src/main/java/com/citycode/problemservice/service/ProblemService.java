package com.citycode.problemservice.service;

import com.citycode.problemservice.dto.ProblemDTO;
import com.citycode.problemservice.exception.HIbernateOperationException;
import com.citycode.problemservice.exception.IdNotFoundException;
import com.citycode.problemservice.model.Problem;
import com.citycode.problemservice.repository.IProblemsRepository;
import jakarta.validation.ConstraintViolationException;
import org.hibernate.StaleStateException;
import org.hibernate.TransientPropertyValueException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProblemService implements IProblemService{

    @Autowired
    private IProblemsRepository problemRepo;


    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<ProblemDTO> getProblems() {
        var problemsBD = problemRepo.findAll();
        var problemsDTO = new ArrayList<ProblemDTO>();

        for (Problem problem : problemsBD) {
            problemsDTO.add(modelMapper.map(problem, ProblemDTO.class));
        }


        return problemsDTO;
    }

    @Override
    public ProblemDTO getProblemById(Long id_problem) throws IdNotFoundException {
        Problem problem = problemRepo.findById(id_problem).orElseThrow(() -> new IdNotFoundException("El id " + id_problem + " no se encuentra registrado"));

        var problemDto = modelMapper.map(problem, ProblemDTO.class);


        return problemDto;
    }

    @Override
    public ProblemDTO saveProblem(ProblemDTO problem) throws HIbernateOperationException {
        var problemsave = modelMapper.map(problem, Problem.class);

        try {
            problemsave = problemRepo.save(problemsave);
        } catch (ConstraintViolationException ex) {
            throw new HIbernateOperationException ("Error de violación de restricción: " + ex.getMessage());
        } catch (TransientPropertyValueException ex) {
            throw new HIbernateOperationException("Error de propiedad transitoria: " + ex.getMessage());
        } catch (StaleStateException ex) {
            throw new HIbernateOperationException("Error de estado obsoleto: " + ex.getMessage());
        } catch (Exception ex) {
            throw new HIbernateOperationException ("Error desconocido al guardar el producto: " + ex.getMessage());
        }


        var problemDtoSave = modelMapper.map(problemsave, ProblemDTO.class);
        return problemDtoSave;
    }
}
