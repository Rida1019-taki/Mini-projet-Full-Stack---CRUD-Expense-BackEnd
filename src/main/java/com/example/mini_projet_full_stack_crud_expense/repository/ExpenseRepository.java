package com.example.mini_projet_full_stack_crud_expense.repository;

import com.example.mini_projet_full_stack_crud_expense.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
