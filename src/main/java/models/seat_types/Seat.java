package models.seat_types;

import models.client_types.Client;

public abstract class Seat {
    private boolean booked; //booked e true daca locul este rezervat, false daca nu este rezervat
    private Client client;
    protected double undiscountedPrice; //pretul de baza, fara vreo reducere aplicata

    /**
     * constructor
     *
     * @param client clientul caruia ii va fi asignat locul respectiv
     */
    public Seat(Client client) {
        this.booked = true;
        this.client = client;
    }

    /**
     * constrcutor
     *
     * @param client            clientul caruia ii va fi asignat locul respectiv
     * @param undiscountedPrice pretul de baza, fara vreo reducere aplicata
     */
    public Seat(Client client, double undiscountedPrice) {
        this.booked = true;
        this.client = client;
        this.undiscountedPrice = undiscountedPrice;
    }

    /**
     * constructor fara parametri
     */
    public Seat() {
        this.booked = false;
        this.client = null;
    }

    /**
     * @return true daca locul este rezervat, false daca nu este rezervat
     */
    public boolean isBooked() {
        return booked;
    }

    /**
     * metoda care schimba starea unui loc (din rezervat in nerezervat, din nerezervat in rezervat)
     *
     * @param booked starea noua a locului respectiv
     */
    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    /**
     * @return clientul care a rezervat locul respectiv (sau null, daca locul este nerezervat)
     */
    public Client getClient() {
        return client;
    }

    /**
     * metoda care schimba clientul caruia ii este asignat locul
     *
     * @param client care rezerva locul
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * @return pretul de baza, fara vreo reducere aplicata, pentru un anumit loc
     */
    public double getUndiscountedPrice() {
        return undiscountedPrice;
    }
}
