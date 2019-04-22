package models.client_types;

public class Child extends Client {
    /**
     * constructor pentru categoria de clienti "Copil"
     *
     * @param firstName prenumele clientului
     * @param lastName  numele clientului
     */
    public Child(String firstName, String lastName) {
        super(firstName, lastName);
        discountPercentage = 25; //copiii au reducere de 25% la biletele de spectacol
    }

    /**
     * constructor fara parametri pentru categoria de clienti "Copil"
     */
    public Child() {
        discountPercentage = 25;
    }
}
