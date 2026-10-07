package com.example.mini_projet_full_stack_crud_expense.mapper;

import com.example.mini_projet_full_stack_crud_expense.dto.ExpenseRequest;
import com.example.mini_projet_full_stack_crud_expense.dto.ExpenseResponse;
import com.example.mini_projet_full_stack_crud_expense.entity.Expense;

public class ExpenseMapper {

    public static Expense toEntity(ExpenseRequest request){
        Expense expense = new Expense();
        expense.setTitre(request.titre());
        expense.setDescription(request.description());
        expense.setMontant(request.montant());
        expense.setCategorie(request.categorie());
        expense.setDateDepense(request.dateDepense());
        expense.setModePaiement(request.modePaiement());
        return expense;
    }

    public static void updateEntity(Expense expense, ExpenseRequest request){

        expense.setTitre(request.titre());
        expense.setDescription(request.description());
        expense.setMontant(request.montant());
        expense.setCategorie(request.categorie());
        expense.setDateDepense(request.dateDepense());
        expense.setModePaiement(request.modePaiement());
    }

    public static ExpenseResponse toResponse(Expense expense){
        return new ExpenseResponse(
                expense.getId(),
                expense.getTitre(),
                expense.getDescription(),
                expense.getMontant(),
                expense.getCategorie(),
                expense.getDateDepense(),
                expense.getModePaiement()
        );
    }
}
