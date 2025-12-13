// BigDecimal vient permettre de gérer les valeurs monétaires avec précision évitant les erreurs d'arrondi avec les float et double.
import java.math.BigDecimal;

// Création de la classe Facture qui sert à gérer les paiements et les cartes clients (classe contexte avec laquelle on délègue pour éviter de surcharger les classes de paiement)
public class Facture {
    // Attributs privés pour la carte client, le montant et la stratégie de paiement
    private CarteClient carte; // vient de la classe CarteClient
    private BigDecimal montant;
    private StrategiePaiement strategiePaiement; // vient de l'interface StrategiePaiement

    /*** IL FAUT PLUSIEURS CONSTRUCTEURS POUR GÉRER LES CAS AVEC OU SANS CARTE CLIENT ***/
    // Constructeur 1: Sans carte client de fidélité (injection de dépendance de l'interface StrategiePaiement uniquement)
    public Facture(BigDecimal montant, StrategiePaiement strategiePaiement) {
        // Initialisation des attributs
        this.montant = montant;
        this.strategiePaiement = strategiePaiement;
        this.carte = null; // doit être null si pas de carte client
        
        // vient appeler la méthode payer de la stratégie de paiement pour effectuer le paiement
        strategiePaiement.payer(montant);
        
        // afficher le message de succès
        String typePaiement = getTypePaiement(strategiePaiement); // définition d'une méthode interne pour obtenir le type de paiement sous forme de chaîne de caractères
        System.out.println("Le paiement par " + typePaiement + " a été fait avec succès.");
    }

    // Constructeur 2: Avec carte client de fidélité (injection de dépendance de l'interface StrategiePaiement et de la classe CarteClient)
    public Facture(BigDecimal montant, StrategiePaiement strategiePaiement, CarteClient carte) {
        // Initialisation des attributs
        this.montant = montant;
        this.strategiePaiement = strategiePaiement;
        this.carte = carte; // pas null car on a une carte client
        
        // vient appeler la méthode payer de l'interface strategiePaiement pour effectuer le paiement
        strategiePaiement.payer(montant);
        
        // Afficher le message de succès
        String typePaiement = getTypePaiement(strategiePaiement); // définition d'une méthode interne pour obtenir le type de paiement sous forme de chaîne de caractères
        System.out.println("Le paiement par " + typePaiement + " a été fait avec succès.");
        
        // si la stratégie de paiement n'est pas une instance de PaiementPoint, alors on récompense le client via la carte client
        if (!(strategiePaiement instanceof PaiementPoint)) {
            carte.recompenser(this); // appelle la méthode recompenser de la classe CarteClient en passant la facture courante (this qui représente l'objet Facture en cours)
        }
    }

    // construction d'une méthode privée pour obtenir le type de paiement sous forme de chaîne de caractères (injection de dépendance de l'interface StrategiePaiement)
    private String getTypePaiement(StrategiePaiement strategie) { 
        if (strategie instanceof PaiementEspeces) { // si la stratégie est une instance de PaiementEspeces
            return "espèces";
        } else if (strategie instanceof PaiementDebit) { // sinon si la stratégie est une instance de PaiementDebit
            return "débit";
        } else if (strategie instanceof PaiementCredit) { // sinon si la stratégie est une instance de PaiementCredit
            return "crédit";
        } else if (strategie instanceof PaiementPoint) { // sinon si la stratégie est une instance de PaiementPoint
            return "points";
        } else {
            return "autre méthode";
        }
    }

    // getter pour obtenir la carte du clien car cet attribut est privé
    public CarteClient getCarte() {
        return carte;
    }

    // getters pour obtenir le montant car cet attribut est privé
    public BigDecimal getMontant() {
        return montant;
    }

    // getter pour obtenir la stratégie de paiement car cet attribut est privé
    public StrategiePaiement getStrategiePaiement() {
        return strategiePaiement;
    }

    // setters pour modifier la carte du client provenant de la classe CarteClient car cet attribut est privé
    public void setCarte(CarteClient carte) {
        this.carte = carte;
    }

    // setter pour modifier le montant car cet attribut est privé
    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    // setter pour modifier la stratégie de paiement provenant de l'interface StrategiePaiement car cet attribut est privé
    public void setStrategiePaiement(StrategiePaiement strategiePaiement) {
        this.strategiePaiement = strategiePaiement;
    }
}

