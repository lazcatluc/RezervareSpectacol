package models.seat_types;

import models.client_types.Client;

public class StandardSeat extends Seat {
    /**
     * constructor fara parametri
     */
    public StandardSeat() {
        this.undiscountedPrice = 50;
    }

    /**
     * constructor pentru categoria de loc "Standard"
     *
     * @param client            clientul pentru care va fi rezervat locul standard
     * @param undiscountedPrice pretul de baza, fara vreo reducere aplicata, specific locului respectiv
     */
    public StandardSeat(Client client, double undiscountedPrice) {
        super(client, undiscountedPrice);
    }
}
