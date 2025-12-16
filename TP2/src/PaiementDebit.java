// Création de la classe PaiementDebit qui implémente l'interface StrategiePaiement
public class PaiementDebit implements StrategiePaiement {
    // Redéfinition de la méthode payer pour le paiement par débit
    @Override
    public void payer(double montant) {
        System.out.println("Paiement par débit de : " + montant + " dollars.");
    }
}
