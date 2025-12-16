// Création de la classe PaiementEspeces qui implémente l'interface StrategiePaiement
public class PaiementEspeces implements StrategiePaiement {
    // Redéfinition de la méthode payer pour le paiement en espèces
    @Override
    public void payer(double montant) {
        System.out.println("Paiement en espèces de : " + montant + " dollars.");
    }
    
    // Redéfinition de la méthode pour obtenir le taux de récompense pour les miles
    @Override
    public double obtenirTauxMiles() {
        return 0.5; // 0.5 mile par dollar
    }
    
    // Redéfinition de la méthode pour obtenir le taux de récompense pour les points
    @Override
    public double obtenirTauxPoints() {
        return 1.0; // 1 point par dollar
    }
}
