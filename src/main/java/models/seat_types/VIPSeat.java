package models.seat_types;

import models.client_types.Client;

public class VIPSeat extends Seat {

    /**
     * constructor fara parametri
     */
    public VIPSeat() {
        this.undiscountedPrice = 100;
    }

    /**
     * constructor pentru categoria de loc "VIP"
     *
     * @param client            clientul pentru care va fi rezervat locul VIP
     * @param undiscountedPrice pretul de baza, fara vreo reducere aplicata, specific locului respectiv
     */
    public VIPSeat(Client client, double undiscountedPrice) {
        super(client, undiscountedPrice);
    }
}
