// Création de l'interface StrategiePaiement
public interface StrategiePaiement {
    // Méthode générale pour payer
    void payer(double montant);
    
    // Méthode générale pour obtenir le taux de récompense en miles (pour éliminer les if instanceof)
    double obtenirTauxMiles();
    
    // Méthode générale pour obtenir le taux de récompense en points (pour éliminer les if instanceof)
    double obtenirTauxPoints();
}
