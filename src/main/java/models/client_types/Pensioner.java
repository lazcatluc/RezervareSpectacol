package models.client_types;

public class Pensioner extends Client {
    /**
     * constructor pentru categoria de clienti "Pensionar"
     *
     * @param firstName prenumele clientului
     * @param lastName  numele clientului
     */
    public Pensioner(String firstName, String lastName) {
        super(firstName, lastName);
        discountPercentage = 30; //pensionarii au reducere de 30% la biletele de spectacol
    }

    /**
     * constructor fara parametri
     */
    public Pensioner() {
        discountPercentage = 30;
    }
}
