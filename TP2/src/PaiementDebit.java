// BigDecimal vient permettre de gérer les valeurs monétaires avec précision évitant les erreurs d'arrondi avec les float et double.
import java.math.BigDecimal;

// Création de la classe PaiementDebit qui implémente l'interface StrategiePaiement
public class PaiementDebit implements StrategiePaiement {
    // Redéfinition de la méthode payer pour le paiement par débit
    @Override
    public void payer(BigDecimal montant) {
        System.out.println("Paiement par débit de : " + montant + " dollars.");
    }

}
