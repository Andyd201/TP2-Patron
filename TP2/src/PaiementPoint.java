// Création de la classe PaiementPoint qui implémente l'interface StrategiePaiement
public class PaiementPoint implements StrategiePaiement {
    // Redéfinition de la méthode payer pour le paiement par point de fidélité
    @Override
    public void payer(double montant) {
        System.out.println("Paiement par point de fidélité de : " + montant + " dollars.");
    }
    
    //*** Pas de récompense en miles lors d'un paiement par points
    // Redéfinition de la méthode pour obtenir le taux de récompense pour les miles
    @Override
    public double obtenirTauxMiles() {
        return 0.0;
    }
    
    // Redéfinitiomn de la méthode pour obtenir le taux de récompense pour les points
    @Override
    public double obtenirTauxPoints() {
        return 0.0;
    }
}
