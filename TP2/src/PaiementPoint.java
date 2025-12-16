// Création de la classe PaiementPoint qui implémente l'interface StrategiePaiement
public class PaiementPoint implements StrategiePaiement {
    // Redéfinition de la méthode payer pour le paiement par point de fidélité
    @Override
    public void payer(double montant) {
        System.out.println("Paiement par point de fidélité de : " + montant + " dollars.");
    }
}
