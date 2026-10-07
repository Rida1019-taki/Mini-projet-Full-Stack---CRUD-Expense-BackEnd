package com.example.mini_projet_full_stack_crud_expense.dto;

import com.example.mini_projet_full_stack_crud_expense.enums.Categorie;
import com.example.mini_projet_full_stack_crud_expense.enums.ModePaiement;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpenseResponse(Long id,
                              String titre,
                              String description,
                              BigDecimal montant,
                              Categorie categorie,
                              LocalDate dateDepense,
                              ModePaiement modePaiement) {
}
