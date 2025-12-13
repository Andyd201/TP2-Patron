// BigDecimal vient permettre de gérer les valeurs monétaires avec précision évitant les erreurs d'arrondi avec les float et double.
import java.math.BigDecimal;

// Création de la classe PaiementPoint qui implémente l'interface StrategiePaiement
public class PaiementPoint implements StrategiePaiement {
    // Redéfinition de la méthode payer pour le paiement par point de fidélité
    @Override
    public void payer(BigDecimal montant) {
        System.out.println("Paiement par point de fidélité de : " + montant + " dollars.");
    }

}
