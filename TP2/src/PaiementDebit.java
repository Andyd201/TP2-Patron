// Création de la classe PaiementDebit qui implémente l'interface StrategiePaiement
public class PaiementDebit implements StrategiePaiement {
    // Redéfinition de la méthode payer pour le paiement par débit
    @Override
    public void payer(double montant) {
        System.out.println("Paiement par débit de : " + montant + " dollars.");
    }
    
    // Redéfinition de la méthode pour obtenir le taux de récompense pour les miles
    @Override
    public double obtenirTauxMiles() {
        return 1.0; // 1 mile par dollar
    }
    
    // Redéfinition de la méthode pour obtenir le taux de récompense pour les points
    @Override
    public double obtenirTauxPoints() {
        return 1.5; // 1.5 points par dollar
    }
}
