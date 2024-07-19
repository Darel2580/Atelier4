class Camion extends Vehicule {
    private double chargementMax;

    public Camion(String marque, String modele, int anneeProduction, double prix, double chargementMax) throws VehiculeInvalidException {
        super(marque, modele, anneeProduction, prix);
        setChargementMax(chargementMax);
    }

    public void setChargementMax(double chargementMax) throws VehiculeInvalidException {
        if (chargementMax < 0) {
            throw new VehiculeInvalidException("Le chargement maximum doit être positif.");
        }
        this.chargementMax = chargementMax;
    }

    @Override
    public String toString() {
        return super.toString() + ", Chargement maximum: " + chargementMax + "kg";
    }
}
