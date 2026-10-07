package com.example.mini_projet_full_stack_crud_expense.dto;

import com.example.mini_projet_full_stack_crud_expense.enums.Categorie;
import com.example.mini_projet_full_stack_crud_expense.enums.ModePaiement;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpenseRequest(@NotBlank(message = "Le titre est obligatoire")
                              String titre,

                             String description,

                             @NotNull(message = "Le montant est obligatoire")
                              @Positive(message = "Le montant doit être positif")
                             BigDecimal montant,

                             @NotNull(message = "La catégorie est obligatoire")
                             Categorie categorie,

                             @NotNull(message = "La date de dépense est obligatoire")
                             LocalDate dateDepense,

                             @NotNull(message = "Le mode de paiement est obligatoire")
                             ModePaiement modePaiement) {
}
