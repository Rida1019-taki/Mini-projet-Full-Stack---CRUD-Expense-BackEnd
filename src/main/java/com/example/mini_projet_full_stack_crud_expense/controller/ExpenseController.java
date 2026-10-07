package com.example.mini_projet_full_stack_crud_expense.controller;

import com.example.mini_projet_full_stack_crud_expense.dto.ExpenseRequest;
import com.example.mini_projet_full_stack_crud_expense.dto.ExpenseResponse;
import com.example.mini_projet_full_stack_crud_expense.service.ExpenseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<ExpenseResponse> create(@Valid @RequestBody ExpenseRequest request){
        ExpenseResponse response = expenseService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseResponse>> getAll(){
        return ResponseEntity.ok(expenseService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(expenseService.egetById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpenseResponse> update(@PathVariable Long id, @Valid @RequestBody ExpenseRequest request){
        return ResponseEntity.ok(expenseService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        expenseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
