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
        // Obtenir le taux de récompense de la stratégie de paiement via une méthode de l'interface StrategiePaiement
        double tauxMiles = f.getStrategiePaiement().obtenirTauxMiles();
        
        // Calculer les miles gagnés en multipliant le montant par le taux
        float milesGagnes = (float) (f.getMontant() * tauxMiles);
        
        // ajouterMiles est une méthode de la classe CarteMiles qui ajoute les miles gagnés au nombre actuel de miles
        ajouterMiles(milesGagnes);
        System.out.println("Récompense: " + milesGagnes + " miles ajoutés. Total: " + nombre_mile + " miles.");
    }

    // Redéfinition de la méthode recompenser(double montant) pour récompenser le client avec des miles basés sur un montant
    @Override
    public void recompenser(double montant) {
        ajouterMiles((float) montant); // ajoute le montant (converti en float) au nombre actuel de miles
    }
}
