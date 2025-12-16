// Création de la classe CartePoints qui hérite de la classe abstraite CarteClient pour les cartes de points
public class CartePoints extends CarteClient {
    // Attribut privé pour le nombre de points de fidélité
    private int nombre_point;

    // Constructeur de la classe CartePoints qui initialise le nom, l'adresse et le nombre de points à 0 (injection de dépendance pour ne pas créer de dépendance forte avec les sous-classes)
    public CartePoints(String nomClient, String adresse) {
        super(nomClient, adresse); // Appel du constructeur de la classe parente (super() permet de venir chercher le constructeur dans la classe mère (CarteClient))
        this.nombre_point = 0; // Initialisation du nombre de points à 0
    }

    // Getter pour le nombre de points (car cet attribut est privé et ne peut pas être accédé directement depuis l'extérieur de la classe (encapsulation))
    public int getNombre_point() {
        return nombre_point;
    }

    // Setter pour le nombre de points (car cet attribut est privé et ne peut pas être modifié directement depuis l'extérieur de la classe)
    public void setNombre_point(int nombre_point) {
        this.nombre_point = nombre_point;
    }

    // Méthode pour ajouter des points (ajoute des points au nombre actuel de points)
    public void ajouterPoints(int points) {
        this.nombre_point += points;
    }

    // Méthode pour utiliser des points (pour paiement par points)
    public boolean utiliserPoints(int points) {
        if (this.nombre_point >= points) { // si le nombre de points est plus grand ou égal aux points à utiliser
            this.nombre_point -= points; // alors on soustrait les points utilisés du nombre actuel de points
            return true; // on retourne true pour indiquer que l'opération a réussi
        }
        return false; // sinon on retourne false pour indiquer que l'opération a échoué
    }

    // Redéfinition de la méthode recompenser(Facture f) pour récompenser le client avec des points de fidélité basés sur une facture
    @Override
    public void recompenser(Facture f) {
        int pointsGagnes = 0; // Initialisation des points gagnés à 0
        
        // Calculer les points selon la stratégie de paiement
        if (f.getStrategiePaiement() instanceof PaiementEspeces) { // si la stratégie de paiement de Facture est une instance de PaiementEspeces
            // les points vaut 1 point pour 1$ dépensé en espèces
            pointsGagnes = (int) (f.getMontant() * 1);
        } else if (f.getStrategiePaiement() instanceof PaiementDebit) { // sinon si la stratégie de paiement de Facture est une instance de PaiementDebit
            // les points vaut 1.5 points pour 1$ dépensé en débit
            pointsGagnes = (int) (f.getMontant() * 1.5);
        } else if (f.getStrategiePaiement() instanceof PaiementCredit) { // sinon si la stratégie de paiement de Facture est une instance de PaiementCredit
            // les points vaut 2 points pour 1$ dépensé en crédit
            pointsGagnes = (int) (f.getMontant() * 2);
        }
        
        // ajouterPoints est une méthode de la classe CartePoints qui ajoute les points gagnés au nombre actuel de points
        ajouterPoints(pointsGagnes);
        System.out.println("Récompense: " + pointsGagnes + " points ajoutés. Total: " + nombre_point + " points.");
    }

    // Redéfinition de la méthode recompenser(double montant) pour récompenser le client avec des points de fidélité basés sur un montant
    @Override
    public void recompenser(double montant) {
        ajouterPoints((int) montant); // ajoute le montant (converti en int) au nombre actuel de points
    }
}
