package models.client_types;

public class Disabled extends Client {
    /**
     * constructor pentru categoria de clienti "PersoanaCuDizabilitati"
     *
     * @param firstName prenumele clientului
     * @param lastName  numele clientului
     */
    public Disabled(String firstName, String lastName) {
        super(firstName, lastName);
        discountPercentage = 100; //persoanele cu dizabilitati au acces gratuit la spectacole
    }

    /**
     * constructor fara parametri
     */
    public Disabled() {
        discountPercentage = 100;
    }
}
