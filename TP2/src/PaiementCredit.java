// Création de la classe PaiementCredit qui implémente l'interface StrategiePaiement
public class PaiementCredit implements StrategiePaiement {
    // Redéfinition de la méthode payer pour le paiement par crédit
    @Override
    public void payer(double montant) {
        System.out.println("Paiement par crédit de : " + montant + " dollars.");
    }
    
    // Redéfinition des taux de récompense pour les miles
    @Override
    public double obtenirTauxMiles() {
        return 2.0; // 2 miles par dollar comme dans le Tableau 1
    }
    
    // Redéfinition des taux de récompense pour les points
    @Override
    public double obtenirTauxPoints() {
        return 2.0; // 2 points par dollar comme dans le Tableau 1
    }
}
