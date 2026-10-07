package com.example.mini_projet_full_stack_crud_expense.entity;

import com.example.mini_projet_full_stack_crud_expense.enums.Categorie;
import com.example.mini_projet_full_stack_crud_expense.enums.ModePaiement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal montant;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private Categorie categorie;

    @Column(name = "date_depense", nullable = false)
    private LocalDate dateDepense;

    @Enumerated(EnumType.STRING)
    @Column(name = "mode_paiement", nullable = false, length = 50)
    private ModePaiement modePaiement;
}
