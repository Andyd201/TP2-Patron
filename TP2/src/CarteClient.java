// Création de la classe abstraite CarteClient qui implémente l'interface StrategiePoint
public abstract class CarteClient implements StrategiePoint {
    // Attributs protégés pour le nom et l'adresse du client
    protected String nomClient;
    protected String adresse;

    // Constructeur protégé pour initialiser le nom et l'adresse du client (injection de dépendance pour ne pas créer de dépendance forte avec les sous-classes)
    protected CarteClient(String nomClient, String adresse) {
        this.nomClient = nomClient; // Initialisation du nom du client
        this.adresse = adresse; // Initialisation de l'adresse du client
    }

    // Méthode abstraite pour récompenser le client avec des points de fidélité basés sur une facture
    public abstract void recompenser(Facture f);
}
