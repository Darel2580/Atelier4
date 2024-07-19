class Moto extends Vehicule {
    private int cylindree;

    public Moto(String marque, String modele, int anneeProduction, double prix, int cylindree) throws VehiculeInvalidException {
        super(marque, modele, anneeProduction, prix);
        setCylindree(cylindree);
    }

    public void setCylindree(int cylindree) throws VehiculeInvalidException {
        if (cylindree < 50 || cylindree > 1200) {
            throw new VehiculeInvalidException("La cylindrée doit être comprise entre 50 et 1200 cm3.");
        }
        this.cylindree = cylindree;
    }

    @Override
    public String toString() {
        return super.toString() + ", Cylindrée: " + cylindree + "cm3";
    }
}
