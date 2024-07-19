// Packages
package com.example.vehicules;

// Imports
import java.io.FileWriter;
import java.io.IOException;
import Camion.Camion;
import ParcVehicules.ParcVehicules;
import Vehicule.Vehicule;
import Voiture.Voiture;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        String nomFichier = "DATASELEMANI.txt";
        String texte = "Gestion des vehicules.";

        try {
            FileWriter writer = new FileWriter(nomFichier, true); // 'true' pour ajouter à la fin du fichier
            writer.write(texte + "\n");
            writer.close();
            System.out.println("Le texte a été écrit avec succès dans " + nomFichier);
        } catch (IOException e) {
            e.printStackTrace();
                            }

        ParcVehicules parc = new ParcVehicules();
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            afficherMenu();
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le saut de ligne

            switch (choix) {
                case 1:
                    ajouterVehicule(parc, scanner);
                    break;
                case 2:
                    supprimerVehicule(parc, scanner);
                    break;
                case 3:
                    modifierVehicule(parc, scanner);
                    break;
                case 4:
                    rechercherVehicule(parc, scanner);
                    break;
                case 5:
                    listerVehicules(parc, scanner);
                    break;
                case 6:
                    afficherNombreVehicules(parc);
                    break;
                case 7:
                    sauvegarderVehicules(parc, scanner);
                    break;
                case 8:
                    chargerVehicules(parc, scanner);
                    break;
                case 9:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
            }
        } while (choix != 9);

        scanner.close();
    }

    private static void rechercherVehicule(ParcVehicules parc, Scanner scanner) {

    }

    private static void listerVehicules(Object parc, Scanner scanner) {

    }

    private static void afficherNombreVehicules(ParcVehicules parc) {
    }

    private static void sauvegarderVehicules(Object parc, Scanner scanner) {

    }

    private static void chargerVehicules(ParcVehicules parc , Scanner scanner) {

    }

    private static void afficherMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Ajouter un véhicule");
        System.out.println("2. Supprimer un véhicule");
        System.out.println("3. Modifier un véhicule");
        System.out.println("4. Rechercher un véhicule");
        System.out.println("5. Lister les véhicules par lettre");
        System.out.println("6. Afficher le nombre de véhicules");
        System.out.println("7. Sauvegarder les véhicules");
        System.out.println("8. Charger les véhicules");
        System.out.println("9. Quitter");
        System.out.print("Votre choix : ");
    }

    private static void ajouterVehicule(ParcVehicules parc, Scanner scanner) {
        System.out.print("Entrez l'identifiant du véhicule : ");
        String id = scanner.nextLine();
        System.out.print("Entrez la marque du véhicule : ");
        String marque = scanner.nextLine();
        System.out.print("Entrez le modèle du véhicule : ");
        String modele = scanner.nextLine();
        System.out.print("Entrez l'année de production du véhicule : ");
        int anneeProduction = scanner.nextInt();
        scanner.nextLine(); // Consommer le saut de ligne
        System.out.print("Entrez le prix du véhicule : ");
        double prix = scanner.nextDouble();
        scanner.nextLine(); // Consommer le saut de ligne
        System.out.print("Entrez le type de véhicule (1 pour Voiture, 2 pour Camion, 3 pour Moto) : ");
        int typeVehicule = scanner.nextInt();
        scanner.nextLine(); // Consommer le saut de ligne

        Vehicule vehicule;
        switch (typeVehicule) {
            case 1:
                System.out.print("Entrez le nombre de portes de la voiture : ");
                int nbPortes = scanner.nextInt();
                scanner.nextLine(); // Consommer le saut de ligne
                vehicule = new Voiture(marque, modele, anneeProduction, prix, nbPortes);

            case 2:
                System.out.print("Entrez le chargement maximum du camion (en kg) : ");
                double chargementMax = scanner.nextDouble();
                scanner.nextLine(); // Consommer le saut de ligne
                vehicule = new Camion(marque, modele, anneeProduction, prix, chargementMax);

            case 3:
                System.out.print("Entrez la cylindrée de la moto (en cm3) : ");
                int cylindree = scanner.nextInt();
                scanner.nextLine(); // Consommer le saut de ligne
               vehicule = new Vehicule();
                break;
            default:
                System.out.println("Type de véhicule invalide.");
                return;
        }

        parc.ajouterVehicule(id, vehicule);
        System.out.println("Véhicule ajouté avec succès.");
    }

    private static void supprimerVehicule(ParcVehicules parc, Scanner scanner) {
        System.out.print("Entrez l'identifiant du véhicule à supprimer : ");
        String id = scanner.nextLine();
        parc.supprimerVehicule(id);

        System.out.println("Véhicule supprimé avec succès.");
    }

    private static void modifierVehicule(ParcVehicules parc, Scanner scanner) {
        try {
            System.out.print("Entrez l'identifiant du véhicule à modifier : ");
            String id = scanner.nextLine();
            System.out.print("Entrez la nouvelle marque du véhicule : ");
            String marque = scanner.nextLine();
            System.out.print("Entrez le nouveau modèle du véhicule : ");
            String modele = scanner.nextLine();
            System.out.print("Entrez la nouvelle année de production du véhicule : ");
            int anneeProduction = scanner.nextInt();
            scanner.nextLine(); // Consommer le saut de ligne
            System.out.print("Entrez le nouveau prix du véhicule : ");
            double prix = scanner.nextDouble();
            scanner.nextLine(); // Consommer le saut de ligne
            System.out.print("Entrez le nouveau type de véhicule (1 pour Voiture, 2 pour Camion, 3 pour Moto) : ");
            int typeVehicule = scanner.nextInt();
            scanner.nextLine();

            Vehicule nouveauVehicule;
            switch (typeVehicule) {
                case 1:
                    System.out.print("Entrez le nouveau nombre de portes de la voiture : ");
                    int nbPortes = scanner.nextInt();
                    scanner.nextLine();
                    nouveauVehicule = new Voiture(marque, modele, anneeProduction, prix, nbPortes);

                case 2:
                    System.out.print("Entrez le nouveau chargement maximum du camion (en kg) : ");
                    double chargementMax = scanner.nextDouble();
                    scanner.nextLine();
                    nouveauVehicule = new Camion(marque, modele, anneeProduction, prix, chargementMax);

                case 3:
                    System.out.print("Entrez la nouvelle cylindrée de la moto (en cm3) : ");
                    int cylindree = scanner.nextInt();
                    scanner.nextLine();
            }
        } finally {
            System.exit(0);
        }
        }
    }
