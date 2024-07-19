abstract class Vehicule {
    protected String marque;
    protected String modele;
    protected int anneeProduction;
    protected double prix;

    public Vehicule(String marque, String modele, int anneeProduction, double prix) throws VehiculeInvalidException {
        setMarque(marque);
        setModele(modele);
        setAnneeProduction(anneeProduction);
        setPrix(prix);
    }

    public void setMarque(String marque) throws VehiculeInvalidException {
        if (marque == null || marque.isEmpty()) {
            throw new VehiculeInvalidException("La marque ne peut pas être vide.");
        }
        this.marque = marque;
    }

    public void setModele(String modele) throws VehiculeInvalidException {
        if (modele == null || modele.isEmpty()) {
            throw new VehiculeInvalidException("Le modèle ne peut pas être vide.");
        }
        this.modele = modele;
    }

    public void setAnneeProduction(int anneeProduction) throws VehiculeInvalidException {
        if (anneeProduction < 1900 || anneeProduction > 2023) {
            throw new VehiculeInvalidException("L'année de production doit être comprise entre 1900 et 2023.");
        }
        this.anneeProduction = anneeProduction;
    }

    public void setPrix(double prix) throws VehiculeInvalidException {
        if (prix < 0) {
            throw new VehiculeInvalidException("Le prix doit être positif.");
        }
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Marque: " + marque + ", Modèle: " + modele + ", Année de production: " + anneeProduction + ", Prix: " + prix + "€";
    }
}
