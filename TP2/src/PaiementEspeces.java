// Création de la classe PaiementEspeces qui implémente l'interface StrategiePaiement
public class PaiementEspeces implements StrategiePaiement {
    // Redéfinition de la méthode payer pour le paiement en espèces
    @Override
    public void payer(double montant) {
        System.out.println("Paiement en espèces de : " + montant + " dollars.");
    }
}
