// importation de la classe BigDecimal pour la gestion des nombres décimaux
import java.math.BigDecimal;

// Création de l'interface StrategiePoint
public interface StrategiePoint {
    // Méthode générale pour appliquer des points de fidélité
    void recompenser(BigDecimal points);

}
