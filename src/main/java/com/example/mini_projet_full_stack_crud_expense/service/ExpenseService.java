package com.example.mini_projet_full_stack_crud_expense.service;

import com.example.mini_projet_full_stack_crud_expense.dto.ExpenseRequest;
import com.example.mini_projet_full_stack_crud_expense.dto.ExpenseResponse;
import com.example.mini_projet_full_stack_crud_expense.entity.Expense;
import com.example.mini_projet_full_stack_crud_expense.exception.ResourceNotFoundException;
import com.example.mini_projet_full_stack_crud_expense.mapper.ExpenseMapper;
import com.example.mini_projet_full_stack_crud_expense.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {

        private final ExpenseRepository expenseRepository;

        public ExpenseResponse create(ExpenseRequest request){
            Expense expense = ExpenseMapper.toEntity(request);
            Expense savedExpense = expenseRepository.save(expense);
            return ExpenseMapper.toResponse(savedExpense);
        }

        public ExpenseResponse update(Long id, ExpenseRequest request){
            Expense expense = expenseRepository.findById(id)
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Expense non trouvée avec l'id : " + id));
            ExpenseMapper.updateEntity(expense, request);
            Expense updateExpense = expenseRepository.save(expense);
            return ExpenseMapper.toResponse(updateExpense);
        }

        public List<ExpenseResponse> getAll(){
            return expenseRepository.findAll().stream().map(ExpenseMapper::toResponse).toList();
        }

        public ExpenseResponse egetById(Long id){
            Expense expense = expenseRepository.findById(id)
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Expense non trouvée avec l'id : " + id));
            return ExpenseMapper.toResponse(expense);
        }

        public void delete(Long id){
            Expense expense = expenseRepository.findById(id)
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Expense non trouvée avec l'id : " + id));
            expenseRepository.delete(expense);
        }
}
