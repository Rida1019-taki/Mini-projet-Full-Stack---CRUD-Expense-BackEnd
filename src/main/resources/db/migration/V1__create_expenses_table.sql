CREATE TABLE expenses (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          titre VARCHAR(255) NOT NULL,
                          description TEXT,
                          montant DECIMAL(10, 2) NOT NULL,
                          categorie VARCHAR(50) NOT NULL,
                          date_depense DATE NOT NULL,
                          mode_paiement VARCHAR(50) NOT NULL
);