package models.client_types;

public class Student extends Client {
    /**
     * constructor pentru categoria de clienti "Student"
     *
     * @param firstName prenumele clientului
     * @param lastName  numele clientului
     */
    public Student(String firstName, String lastName) {
        super(firstName, lastName);
        discountPercentage = 50; //studentii au reducere de 50% la biletele de spectacol
    }

    /**
     * constructor fara parametri
     */
    public Student() {
        discountPercentage = 50;
    }
}
