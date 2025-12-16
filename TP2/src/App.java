/*** À LIRE ***
En lisant le TP j'ai vu ça :
4)	Refaire la conception en respectant les principes Solid et en utilisant le patron de conception 
«Stratégie». 
5)	Implémentez la nouvelle conception en utilisant java. 
6)	Proposez un autre patron de conception (différent de « Stratégie ») qui pourrait améliorer la 
conception globale de ce système de fidélisation.

Donc je crois qu'il faut en premier utiliser le patron Strategy et après un autre patron de 
conception comme Factory
*/

// Classe principale pour démontrer le programme de fidélisation
public class App {
    public static void main(String[] args) {

        // Création des instances de stratégies de paiement
        StrategiePaiement paiementEspeces = new PaiementEspeces(); // objet de la classe PaiementEspeces implémentant l'interface StrategiePaiement
        StrategiePaiement paiementDebit = new PaiementDebit(); // objet de la classe PaiementDebit implémentant l'interface StrategiePaiement
        StrategiePaiement paiementCredit = new PaiementCredit(); // objet de la classe PaiementCredit implémentant l'interface StrategiePaiement
        StrategiePaiement paiementPoint = new PaiementPoint(); // objet de la classe PaiementPoint implémentant l'interface StrategiePaiement

        //======================= AVEC LE CONSTRUCTEUR 1 DE LA CLASSE FACTURE =======================

        // création de l'instance de la classe Facture avec pour stratégie de paiement PaiementEspeces
        System.out.println("*** Client sans carte - paiement espèces ***");
        double montant1 = 74.00; 
        Facture facture1 = new Facture(montant1, paiementEspeces); // on injecte à facture1 le montant et la stratégie de paiement paiementEspeces
        System.out.println();

        //======================= AVEC LE CONSTRUCTEUR 2 DE LA CLASSE FACTURE ( FACTURES POUR ANDY) =======================

        // création de l'instance de la classe Facture avec pour stratégie de paiement PaiementEspeces et une carte Air Miles
        System.out.println("*** Client avec carte Air Miles - paiement espèces ***");
        CarteMiles carteAndy = new CarteMiles("Andy Douangpanya", "4356, boulevard Pie-IX, Montréal"); // création de la carte de fidélité Air Miles pour Andy
        double montant2 = 23.00; // création du montant de la facture
        Facture facture2 = new Facture(montant2, paiementEspeces, carteAndy); // on injecte à facture2 le montant, la stratégie de paiement paiementEspeces et la carte de fidélité carteAndy
        System.out.println();

        // Création de l'instance de la classe Facture avec pour stratégie de paiement PaiementDebit et une carte Air Miles
        System.out.println("*** Client avec carte Air Miles - paiement débit ***");
        double montant3 = 101.00; // création du montant de la facture
        Facture facture3 = new Facture(montant3, paiementDebit, carteAndy); // on injecte à facture3 le montant, la stratégie de paiement paiementDebit et la carte de fidélité carteAndy
        System.out.println();

        // création de l'instance de la classe Facture avec pour stratégie de paiement PaiementCredit et une carte Air Miles
        System.out.println("*** Client avec carte Air Miles - paiement crédit ***");
        double montant4 = 56.00;
        Facture facture4 = new Facture(montant4, paiementCredit, carteAndy); // on injecte à facture4 le montant, la stratégie de paiement paiementCredit et la carte de fidélité carteAndy
        System.out.println();

        //======================= AVEC LE CONSTRUCTEUR 2 DE LA CLASSE FACTURE ( FACTURES CHÈRES POUR MARILOU) =======================

        // Création de l'instance de la classe Facture avec pour stratégie de paiement PaiementEspeces et une carte Points
        System.out.println("*** Cliente avec carte de Points - paiement espèces ***");
        CartePoints carteMarilou = new CartePoints("Marilou Aiko Fukuyama", "2650, rue Laurier, Montréal");
        double montant5 = 5000.00; // Marilou aime dépenser :)
        Facture facture5 = new Facture(montant5, paiementEspeces, carteMarilou);  // on injecte à facture5 le montant, la stratégie de paiement paiementEspeces et la carte de fidélité carteMarilou
        System.out.println();

        // création de l'instance de la classe Facture avec pour stratégie de paiement PaiementDebit et une carte Points
        System.out.println("*** Cliente avec carte de Points - paiement débit) ***");
        double montant6 = 75000.00;
        Facture facture6 = new Facture(montant6, paiementDebit, carteMarilou); // on injecte à facture6 le montant, la stratégie de paiement paiementDebit et la carte de fidélité carteMarilou
        System.out.println();

        // Création de l'instance de la classe Facture avec pour stratégie de paiement PaiementCredit et une carte Points
        System.out.println("*** Cliente avec carte de Points - paiement crédit ***");
        double montant7 = 100000000.00;
        Facture facture7 = new Facture(montant7, paiementCredit, carteMarilou); // on injecte à facture7 le montant, la stratégie de paiement paiementCredit et la carte de fidélité carteMarilou
        System.out.println();

        //=============================== FACTURE AVEC PAIEMENT PAR POINTS (MARILOU) =======================

        // création de l'instance de la classe Facture avec pour stratégie de paiement PaiementPoint et une carte Points    
        System.out.println("*** Cliente avec carte de Points - paiement par points ***");
        System.out.println("Points avant paiement: " + carteMarilou.getNombre_point()); // getNombre_point est une méthode de la classe CartePoints qui retourne le nombre de points actuels
        double montant8 = 3700.00;
        Facture facture8 = new Facture(montant8, paiementPoint, carteMarilou); // on injecte à facture8 le montant, la stratégie de paiement paiementPoint et la carte de fidélité carteMarilou
        System.out.println("Points après paiement: " + carteMarilou.getNombre_point()); // on vient appeler getNombre_point pour afficher le nombre de points restants après le paiement
        System.out.println();

        // Affichage final des totaux pour Andy et Marilou
        System.out.println("*** Totaux finaux des cartes de fidélité ***");
        System.out.println("Andy Douangpanya (Air Miles): " + carteAndy.getNombre_mile() + " miles");
        System.out.println("Marilou Aiko Fukuyama (Points): " + carteMarilou.getNombre_point() + " points");
    }
}


/*
Questions :
1)	La définition de la fonction récompenser(facture f) des cartes clients n’est pas la responsabilité de la carte client. 
Quel est le principe (parmi les principes SOLID) qui a été violé ? 
Le principe de responsabilité unique (Single Responsibility Principle - SRP) a été violé. Selon ce principe, 
une classe ne doit avoir qu'une seule raison de changer, c'est-à-dire qu'elle doit se concentrer sur une seule 
responsabilité. En définissant la fonction récompenser(facture f) dans la classe carte client, on mélange la 
responsabilité de gestion des récompenses avec celle de la gestion des informations du client, ce qui complique 
la maintenance et l'évolution du code.





2)	La récompense telle qu’elle a été définit, elle dépend du mode de payement et d’une instance de la classe facture. Quel est le principe qui a été violé et pourquoi ? 






3)	Si vous déplacez la définition de la récompensassions des carte clients dans la carte facture, vous allez violer un des principes SOLID. Lequel ? 








4)	Refaire la conception en respectant les principes Solid et en utilisant le patron de conception «Stratégie». 
5)	Implémentez la nouvelle conception en utilisant java. 
6)	Proposez un autre patron de conception (différent de « Stratégie ») qui pourrait améliorer la conception globale de ce système de fidélisation.

Pour le patron choisi :
a) Nommez le patron et décrivez en quelques phrases le problème de conception qu’il permettrait de résoudre dans ce contexte (par exemple : création d’objets, extension des types de cartes, combinaison de plusieurs comportements, etc.).
b) Expliquez comment vous l’intégreriez dans votre modèle :
•	quelles classes existantes seraient impactées ;
•	quelles nouvelles classes ou interfaces seraient ajoutées ;
•	quelles responsabilités seraient déplacées ou mieux isolées.
c) Donnez un exemple concret d’évolution du système (par exemple : ajout d’un nouveau type de carte, d’une règle de récompense spéciale pour certaines périodes, d’un nouveau moyen de paiement, etc.) et expliquez en quoi l’utilisation de ce patron rend cette évolution plus simple et plus conforme aux principes SOLID.
d) Discutez brièvement des limites ou des coûts de ce patron dans ce contexte 

*/ 
