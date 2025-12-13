// BigDecimal vient permettre de gérer les valeurs monétaires avec précision évitant les erreurs d'arrondi avec les float et double.
import java.math.BigDecimal;

// Création de la classe CarteMiles qui hérite de la classe abstraite CarteClient pour les cartes Air Miles
public class CarteMiles extends CarteClient {
    // Attribut privé pour le nombre de miles en float
    private float nombre_mile;

    // Constructeur de la classe CarteMiles initialisant le nom du client, l'adresse et le nombre de miles à 0 (injection de dépendance pour ne pas créer de dépendance forte avec les sous-classes de StrategiePaiement)
    public CarteMiles(String nomClient, String adresse) {
        super(nomClient, adresse); // Appel au constructeur de la classe mère CarteClient (super() permet de venir chercher le constructeur dans la classe mère (CarteClient))
        this.nombre_mile = 0; // Initialisation du nombre de miles à 0
    }

    // Getter pour le nombre de miles (car cet attribut est privé et ne peut pas être accédé directement depuis l'extérieur de la classe (encapsulation))
    public float getNombre_mile() {
        return nombre_mile;
    }

    // Setter pour le nombre de miles (car cet attribut est privé et ne peut pas être modifié directement depuis l'extérieur de la classe (encapsulation))
    public void setNombre_mile(float nombre_mile) {
        this.nombre_mile = nombre_mile; 
    }

    // Méthode pour ajouter des miles 
    public void ajouterMiles(float miles) {
        this.nombre_mile += miles;
    }

    // Redéfinition de la méthode recompenser(Facture f) pour récompenser le client avec des miles basés sur une facture
    @Override
    public void recompenser(Facture f) { 
        float milesGagnes = 0; // Initialisation des miles gagnés à 0
        
        // Calculer les miles selon la stratégie de paiement
        if (f.getStrategiePaiement() instanceof PaiementEspeces) { // si la stratégie de paiement de Facture est une instance de PaiementEspeces
            // alors les miles gagnés sont calculés en fonction du montant dépensé en espèces (1 mile par 20$ dépensés)
            milesGagnes = f.getMontant().floatValue() / 20;
        } else if (f.getStrategiePaiement() instanceof PaiementDebit) { // sinon si la stratégie de paiement de Facture est une instance de PaiementDebit
            // alors les miles gagnés sont calculés en fonction du montant dépensé par débit (1 mile par 15$ dépensés)
            milesGagnes = f.getMontant().floatValue() / 15;
        } else if (f.getStrategiePaiement() instanceof PaiementCredit) { // sinon si la stratégie de paiement de Facture est une instance de PaiementCredit
            // alors les miles gagnés sont calculés en fonction du montant dépensé par crédit (1 mile par 10$ dépensés)
            milesGagnes = f.getMontant().floatValue() / 10;
        }
        
        // ajouterMiles est une méthode de la classe CarteMiles qui ajoute les miles gagnés au nombre actuel de miles
        ajouterMiles(milesGagnes);
        System.out.println("Récompense: " + milesGagnes + " miles ajoutés. Total: " + nombre_mile + " miles.");
    }

    // Redéfinition de la méthode recompenser(BigDecimal points) pour récompenser le client avec des miles basés sur un montant de points
    @Override
    public void recompenser(BigDecimal points) {
        ajouterMiles(points.floatValue()); // ajoute les points (convertis en float) au nombre actuel de miles
    }
}
