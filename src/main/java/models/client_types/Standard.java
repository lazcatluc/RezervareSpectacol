package models.client_types;

public class Standard extends Client {
    /**
     * constructor pentru categoria de clienti "Standard"
     *
     * @param firstName prenumele clientului
     * @param lastName  numele clientului
     */
    public Standard(String firstName, String lastName) {
        super(firstName, lastName);
        discountPercentage = 0; //clientii "Standard" nu au niciun fel de reducere la biletele de spectacol
    }

    /**
     * constructor fara parametri
     */
    public Standard() {
        discountPercentage = 0;
    }
}
