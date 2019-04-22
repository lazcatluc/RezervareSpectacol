/*
 * Definirea sistemului
 *
 * Tipuri de obiecte:
 * Client (Client), Copil (Child), Student (Student), Standard (Standard), Pensionar (Pensioner),
 * Persoana cu dizabilitati (Disabled), Loc (Seat), Loc standard (StandardSeat), Loc VIP (VIPSeat),
 * Sala de spectacol (Auditorium), Spectacol (Show)
 *
 * Actiuni/interogari (definite in clasa Service):
 * areThereAnyAvailableStandardSeats(Show show)
 * areThereAnyAvailableVIPSeats(Show show)
 * bookAStandardSeat(Show show, Client client)
 * bookAVIPSeat(Show show, Client client)
 * checkIfStandardBooked(Show show, int index)
 * checkIfVIPBooked(Show show, int index)
 * viewAllSeats(Show show)
 * findStandardSeatBookedBy(Show show, Client client)
 * findVIPSeatBookedBy(Show show, Client client)
 * findSeatBookedBy(Show show, Client client)
 * cancelReservationBy(Show show, Client client)
 * viewAllBookedSeatsAlphabeticallyByClientsName(Show show)
 * calculateRevenue(Show show)
 */

import models.Show;
import models.client_types.*;
import services.Service;

public class Main {
    public static void main(String[] args) {
        Show firstShow = new Show("Primul spectacol", "24-03-2019", "21:00");
        Client client1 = new Child("George", "Cosbuc");
        Client client2 = new Student("Mihai", "Eminescu");
        Client client3 = new Pensioner("Ion", "Pillat");

        Service service = new Service();
        service.bookAStandardSeat(firstShow, client1);
        service.bookAStandardSeat(firstShow, client2);
        service.bookAStandardSeat(firstShow, client3);

        if (service.areThereAnyAvailableStandardSeats(firstShow))
            System.out.println("Exista locuri standard nerezervate la " + firstShow.toString());
        else
            System.out.println("Nu exista locuri standard nerezervate la " + firstShow.toString());

        service.viewAllSeats(firstShow);

        int seatIndex = service.findStandardSeatBookedBy(firstShow, client2);
        if (seatIndex != -1)
            System.out.println("Locul rezervat de " + client2.toString() + " este locul " + (seatIndex + 1));
        else
            System.out.println("Nu exista un loc standard rezervat de catre " + client2.toString());

        seatIndex = service.findVIPSeatBookedBy(firstShow, client2);
        if (seatIndex != -1)
            System.out.println("Locul rezervat de " + client2.toString() + " este locul " + (seatIndex + 1));
        else
            System.out.println("Nu exista un loc VIP rezervat de catre " + client2.toString());

        service.cancelReservationBy(firstShow, client2);//anulez rezervarea clientului2

        seatIndex = service.findStandardSeatBookedBy(firstShow, client2);
        if (seatIndex != -1)
            System.out.println("Locul rezervat de " + client2.toString() + " este locul " + (seatIndex + 1));
        else
            System.out.println("Nu exista un loc standard rezervat de catre " + client2.toString());

        service.viewAllSeats(firstShow);

        service.viewAllBookedSeatsAlphabeticallyByClientsName(firstShow);

        System.out.println("Total incasari pentru " + firstShow.toString() + ": " + service.calculateRevenue(firstShow));

        service.bookAStandardSeat(firstShow, client2);

        Show secondShow = new Show("Al doilea spectacol", "25-03-2019", "20:00",
                100, 200);
        Client client4 = new Pensioner("Ioan", "Slavici");
        Client client5 = new Student("George", "Bacovia");
        Client client6 = new Standard("Ion", "Rebreanu");
        service.bookAStandardSeat(secondShow, client4);
        service.bookAStandardSeat(secondShow, client5);
        service.bookAVIPSeat(secondShow, client6);

        System.out.println("Total incasari pentru " + secondShow.toString() + ": " + service.calculateRevenue(secondShow));
    }
}
