package com.example.mini_projet_full_stack_crud_expense.controller;

import com.example.mini_projet_full_stack_crud_expense.dto.ExpenseRequest;
import com.example.mini_projet_full_stack_crud_expense.dto.ExpenseResponse;
import com.example.mini_projet_full_stack_crud_expense.enums.Categorie;
import com.example.mini_projet_full_stack_crud_expense.enums.ModePaiement;
import com.example.mini_projet_full_stack_crud_expense.service.ExpenseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
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

    @GetMapping("/categorie/{categorie}")
    public ResponseEntity<List<ExpenseResponse>> findByCategorie(@PathVariable Categorie categorie){
        return ResponseEntity.ok(expenseService.findByCategorie(categorie));
    }

    @GetMapping("/modePaiemnt/{modePaiemnt}")
    public ResponseEntity<List<ExpenseResponse>> findByModePaiement(@PathVariable ModePaiement modePaiemnt){
        return ResponseEntity.ok(expenseService.findByModePaiement(modePaiemnt));
    }

    @GetMapping("/dateDepenseAfter/{dateDepenseAfter}")
    public ResponseEntity<List<ExpenseResponse>> findByDateDepenseAfter(@PathVariable LocalDate dateDepenseAfter){
        return ResponseEntity.ok(expenseService.findByDateDepenseAfter(dateDepenseAfter));
    }

    @GetMapping("/montantGreaterThan/{montantGreaterThan}")
    public ResponseEntity<List<ExpenseResponse>> findByMontantGreaterThan(@PathVariable BigDecimal montantGreaterThan){
        return ResponseEntity.ok(expenseService.findByMontantGreaterThan(montantGreaterThan));
    }

    @GetMapping("/depenseBetweenTwoDate/{dateDebut}/{dateFin}")
    public ResponseEntity<List<ExpenseResponse>> findDepenseBetweenTwoDate(@PathVariable LocalDate dateDebut, @PathVariable LocalDate dateFin){
        return ResponseEntity.ok(expenseService.findDepenseBetweenTwoDate(dateDebut, dateFin));
    }

    @GetMapping("/calculerMontantTotal")
    public ResponseEntity<BigDecimal> CalculerMontantTotal(){
        return ResponseEntity.ok(expenseService.CalculerMontantTotal());
    }

    @GetMapping("/calculerMontantTotalParCategorie/{categorie}")
    public ResponseEntity<BigDecimal> CalculerMontantParCategorie(@PathVariable Categorie categorie){
        return ResponseEntity.ok(expenseService.CalculerMontantParCategorie(categorie));
    }

    @GetMapping("/depenseAyantLeMontant")
    public ResponseEntity<BigDecimal> DepenseAyantLeMontant(){
        return ResponseEntity.ok(expenseService.DepenseAyantLeMontant());
    }
}
