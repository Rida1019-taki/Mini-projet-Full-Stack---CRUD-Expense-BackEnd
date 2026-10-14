package com.example.mini_projet_full_stack_crud_expense.repository;

import com.example.mini_projet_full_stack_crud_expense.dto.ExpenseResponse;
import com.example.mini_projet_full_stack_crud_expense.entity.Expense;
import com.example.mini_projet_full_stack_crud_expense.enums.Categorie;
import com.example.mini_projet_full_stack_crud_expense.enums.ModePaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<ExpenseResponse> findByCategorie(Categorie categorie);

    List<ExpenseResponse> findByModePaiement(ModePaiement modePaiement);

    List<ExpenseResponse> findByDateDepenseAfter(LocalDate dateDepenseAfter);

    List<ExpenseResponse> findByMontantGreaterThan(BigDecimal montantIsGreaterThan);
}
