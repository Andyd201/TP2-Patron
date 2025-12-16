// Création de la classe PaiementCredit qui implémente l'interface StrategiePaiement
public class PaiementCredit implements StrategiePaiement {
    // Redéfinition de la méthode payer pour le paiement par crédit
    @Override
    public void payer(double montant) {
        System.out.println("Paiement par crédit de : " + montant + " dollars.");
    }
}
