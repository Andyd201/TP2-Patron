// BigDecimal vient permettre de gérer les valeurs monétaires avec précision évitant les erreurs d'arrondi avec les float et double.
import java.math.BigDecimal;

// Création de l'interface StrategiePaiement
public interface StrategiePaiement {
    // Méthode générale pour payer
    void payer(BigDecimal montant);

}
