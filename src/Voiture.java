class Voiture extends Vehicule {
    private int nbPortes;

    public Voiture(String marque, String modele, int anneeProduction, double prix, int nbPortes) throws VehiculeInvalidException {
        super(marque, modele, anneeProduction, prix);
        setNbPortes(nbPortes);
    }

    public void setNbPortes(int nbPortes) throws VehiculeInvalidException {
        if (nbPortes < 2 || nbPortes > 5) {
            throw new VehiculeInvalidException("Le nombre de portes doit être compris entre 2 et 5.");
        }
        this.nbPortes = nbPortes;
    }

    @Override
    public String toString() {
        return super.toString() + ", Nombre de portes: " + nbPortes;
    }
}
