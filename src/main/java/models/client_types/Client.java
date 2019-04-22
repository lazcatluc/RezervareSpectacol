package models.client_types;

public abstract class Client {
    private String firstName; //prenumele clientului
    private String lastName; //numele clientului
    protected int discountPercentage; //reducerea, care difera in functie de sub-categoria din care face parte clientul

    /**
     * constructor cu parametri
     *
     * @param firstName          prenumele clientului
     * @param lastName           numele clientului
     * @param discountPercentage procentul de reducere a pretului
     */
    public Client(String firstName, String lastName, int discountPercentage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.discountPercentage = discountPercentage;
    }

    /**
     * constructor cu parametri
     *
     * @param firstName prenumele clientului
     * @param lastName  numele clientului
     */
    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * constructor fara parametri
     */
    public Client() {
    }

    /**
     * @return prenumele clientului
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return numele clientului
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return procentul de reducere a pretului
     */
    public int getDiscountPercentage() {
        return discountPercentage;
    }

    /**
     * @return reprezentare a unui obiect de tip "Client" sub forma unui String
     */
    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
