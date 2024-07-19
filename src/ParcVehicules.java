import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ParcVehicules {
    private Map<String, Vehicule> vehicules;

    public ParcVehicules() {
        this.vehicules = new HashMap<>();
    }

    public void ajouterVehicule(String id, Vehicule vehicule) {
        vehicules.put(id, vehicule);
    }

    public void supprimerVehicule(String id) {
        vehicules.remove(id);
    }

    public void modifierVehicule(String id, Vehicule nouveauVehicule) {
        vehicules.put(id, nouveauVehicule);
    }

    public Vehicule rechercherVehicule(String nom) {
        for (Vehicule vehicule : vehicules.values()) {
            if (vehicule.marque.equalsIgnoreCase(nom) || vehicule.modele.equalsIgnoreCase(nom)) {
                return vehicule;
            }
        }
        return null;
    }

    public List<Vehicule> listerVehicules(char lettre) {
        List<Vehicule> vehiculesParLettre = new ArrayList<>();
        for (Vehicule vehicule : vehicules.values()) {
            if (Character.toUpperCase(vehicule.marque.charAt(0)) == Character.toUpperCase(lettre)) {
                vehiculesParLettre.add(vehicule);
            }
        }
        return vehiculesParLettre;
    }

    public int getNombreVehicules() {
        return vehicules.size();
    }

    public void sauvegarderVehicules(String fichier) {
        try (FileWriter writer = new FileWriter(fichier)) {
            for (Map.Entry<String, Vehicule> entry : vehicules.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue().toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des véhicules : " + e.getMessage());
        }
    }

    public void chargerVehicules(String fichier) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fichier))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] parts = ligne.split(",");
                String id = parts[0];
                String marque = parts[1];
                String modele = parts[2];
                int anneeProduction = Integer.parseInt(parts[3]);
                double prix = Double.parseDouble(parts[4]);
                Vehicule vehicule;
                if (parts.length == 6) {
                    int nbPortes = Integer.parseInt(parts[5]);
                    vehicule = new Voiture(marque, modele, anneeProduction, prix, nbPortes);
                } else if (parts.length == 6) {
                    double chargementMax = Double.parseDouble(parts[5]);
                    vehicule = new Camion(marque, modele, anneeProduction, prix, chargementMax);
                } else {
                    int cylindree = Integer.parseInt(parts[5]);
                    vehicule = new Moto(marque, modele, anneeProduction, prix, cylindree);
                }
                ajouterVehicule(id, vehicule);
            }
        } catch (IOException | VehiculeInvalidException e) {
            System.out.println("Erreur lors du chargement des véhicules : " + e.getMessage());
        }
    }
}
