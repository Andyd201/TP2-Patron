// BigDecimal vient permettre de gérer les valeurs monétaires avec précision évitant les erreurs d'arrondi avec les float et double.
import java.math.BigDecimal;

// Création de la classe PaiementEspeces qui implémente l'interface StrategiePaiement
public class PaiementEspeces implements StrategiePaiement {
    // Redéfinition de la méthode payer pour le paiement en espèces
    @Override
    public void payer(BigDecimal montant) {
        System.out.println("Paiement en espèces de : " + montant + " dollars.");
    }

}
