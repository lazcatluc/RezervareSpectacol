package services;

import models.Auditorium;
import models.Show;
import models.client_types.Client;
import models.seat_types.Seat;
import models.seat_types.StandardSeat;
import models.seat_types.VIPSeat;

import java.util.ArrayList;
import java.util.SortedSet;

public class Service {
    /**
     * metoda ce verifica daca mai exista locuri standard nerezervate
     *
     * @param show spectacolul pentru care se verifica numarul de locuri
     * @return true, daca mai exista locuri; false, daca toate locurile standard sunt rezervate
     */
    public boolean areThereAnyAvailableStandardSeats(Show show) {
        Auditorium auditorium = show.getAuditorium();
        ArrayList<StandardSeat> standardSeats = auditorium.getStandardSeats();
        for (int i = 0; i < standardSeats.size(); i++)
            if (!standardSeats.get(i).isBooked()) //daca gasesc un loc liber
                return true;
        if (standardSeats.size() + 1 < auditorium.getNumberOfStandardSeats()) //daca mai pot adauga un loc in sala
            return true;
        return false;
    }

    /**
     * metoda ce verifica daca mai exista locuri VIP nerezervate
     *
     * @param show spectacolul pentru care se verifica numarul de locuri
     * @return true, daca mai exista locuri; false, daca toate locurile VIP sunt rezervate
     */
    public boolean areThereAnyAvailableVIPSeats(Show show) {
        Auditorium auditorium = show.getAuditorium();
        ArrayList<VIPSeat> vipSeats = auditorium.getVIPSeats();
        for (int i = 0; i < vipSeats.size(); i++)
            if (!vipSeats.get(i).isBooked()) //daca gasesc un loc liber
                return true;
        if (vipSeats.size() + 1 < auditorium.getNumberOfVIPSeats()) //daca mai pot adauga un loc in sala
            return true;
        return false;
    }

    /**
     * metoda de rezervare a unui loc standard
     *
     * @param show   spectacolul la care se va incerca rezervarea
     * @param client clientul care doreste rezervarea
     */
    public void bookAStandardSeat(Show show, Client client) {
        Auditorium auditorium = show.getAuditorium();
        ArrayList<StandardSeat> standardSeats = auditorium.getStandardSeats();
        boolean booked = false;
        for (int i = 0; (!booked && i < standardSeats.size()); i++) //caut un loc liber in sala
            if (!standardSeats.get(i).isBooked()) {
                standardSeats.get(i).setBooked(true);
                standardSeats.get(i).setClient(client);
                SortedSet<Client> clients = auditorium.getClients();
                clients.add(client);
                auditorium.setClients(clients);
                System.out.println("Loc standard " + (i + 1) + " ocupat de " + standardSeats.get(i).getClient().toString());
                booked = true;
            }
        if (!booked && standardSeats.size() + 1 < auditorium.getNumberOfStandardSeats()) //daca mai pot adauga un loc in sala
        {
            StandardSeat standardSeat = new StandardSeat(client, auditorium.getUndiscountedStandardPrice());
            standardSeats.add(standardSeat);
            SortedSet<Client> clients = auditorium.getClients();
            clients.add(client);
            auditorium.setClients(clients);
            System.out.println("Loc standard " + (standardSeats.size()) + " rezervat cu succes de catre " +
                    standardSeats.get(standardSeats.size() - 1).getClient().toString());
            booked = true;
        }
        if (!booked) //daca nu mai exista locuri
            System.out.println("Nu mai exista locuri standard la " + show.toString());
    }

    /**
     * metoda de rezervare a unui loc VIP
     *
     * @param show   spectacolul la care se va incerca rezervarea
     * @param client clientul care doreste rezervarea
     */
    public void bookAVIPSeat(Show show, Client client) {
        Auditorium auditorium = show.getAuditorium();
        ArrayList<VIPSeat> vipSeats = auditorium.getVIPSeats();
        boolean booked = false;
        for (int i = 0; (!booked && i < vipSeats.size()); i++) //caut un loc liber in sala
            if (!vipSeats.get(i).isBooked()) {
                vipSeats.get(i).setBooked(true);
                vipSeats.get(i).setClient(client);
                SortedSet<Client> clients = auditorium.getClients();
                clients.add(client);
                auditorium.setClients(clients);
                System.out.println("Loc VIP " + i + 1 + " rezervat cu succes de catre" + vipSeats.get(i).getClient().toString());
                booked = true;
            }
        if (!booked && vipSeats.size() + 1 < auditorium.getNumberOfVIPSeats()) //daca mai pot adauga un loc in sala
        {
            VIPSeat vipSeat = new VIPSeat(client, auditorium.getUndiscountedVIPPrice());
            vipSeats.add(vipSeat);
            SortedSet<Client> clients = auditorium.getClients();
            clients.add(client);
            auditorium.setClients(clients);
            System.out.println("Loc VIP " + (vipSeats.size()) + " rezervat cu succes de catre " +
                    vipSeats.get(vipSeats.size() - 1).getClient().toString());
            booked = true;
        }
        if (!booked) //daca nu mai exista locuri
            System.out.println("Nu mai exista locuri VIP la " + show.toString());
    }

    /**
     * metoda ce verifica daca un loc standard este rezervat
     *
     * @param show  spectacolul vizat
     * @param index indexul locului vizat
     * @return true, daca locul este rezervat; false, in caz contrar
     */
    public boolean checkIfStandardBooked(Show show, int index) {
        Auditorium auditorium = show.getAuditorium();
        ArrayList<StandardSeat> standardSeats = auditorium.getStandardSeats();
        if (index < standardSeats.size()) //daca locul exista deja in sala
            return standardSeats.get(index - 1).isBooked();
        return (index < auditorium.getNumberOfStandardSeats()); //daca indexul nu depaseste capacitatea salii
    }

    /**
     * metoda ce verifica daca un loc VIP este rezervat
     *
     * @param show  spectacolul vizat
     * @param index indexul locului vizat
     * @return true, daca locul este rezervat; false, in caz contrar
     */
    public boolean checkIfVIPBooked(Show show, int index) {
        Auditorium auditorium = show.getAuditorium();
        ArrayList<VIPSeat> vipSeats = auditorium.getVIPSeats();
        if (index < vipSeats.size()) //daca locul exista deja in sala
            return vipSeats.get(index - 1).isBooked();
        return (index < auditorium.getNumberOfVIPSeats()); //daca indexul nu depaseste capacitatea salii
    }

    /**
     * metoda de afisare a tuturor locurilor din sala de spectacol
     *
     * @param show spectacolul vizat
     */
    public void viewAllSeats(Show show) {
        Auditorium auditorium = show.getAuditorium();
        System.out.println("Standard:");
        ArrayList<StandardSeat> standardSeats = auditorium.getStandardSeats();
        for (int i = 0; i < standardSeats.size(); i++) {
            if (standardSeats.get(i).isBooked()) //daca locul este rezervat
                System.out.println("Loc " + (i + 1) + " rezervat de " + standardSeats.get(i).getClient().toString());
            else
                System.out.println("Loc " + (i + 1) + " nerezervat");
        }
        for (int i = standardSeats.size(); i < auditorium.getNumberOfStandardSeats(); i++)
            System.out.println("Loc " + (i + 1) + " nerezervat");

        System.out.println("\nVIP:");
        ArrayList<VIPSeat> vipSeats = auditorium.getVIPSeats();
        for (int i = 0; i < vipSeats.size(); i++) {
            if (vipSeats.get(i).isBooked()) //daca locul este rezervat
                System.out.println("Loc " + (i + 1) + " rezervat de " + vipSeats.get(i).getClient().toString());
            else
                System.out.println("Loc " + (i + 1) + " nerezervat");
        }
        for (int i = vipSeats.size(); i < auditorium.getNumberOfVIPSeats(); i++)
            System.out.println("Loc " + (i + 1) + " nerezervat");
    }

    /**
     * metoda de cautare a locului standard rezervat de un anumit client
     *
     * @param show   spectacolul la care este facuta rezervarea
     * @param client clientul care a facut rezervarea
     * @return indicele locului standard rezervat de client (sau -1 daca nu exista)
     */
    public int findStandardSeatBookedBy(Show show, Client client) {
        Auditorium auditorium = show.getAuditorium();
        ArrayList<StandardSeat> standardSeats = auditorium.getStandardSeats();
        for (int i = 0; i < standardSeats.size(); i++)

            if (standardSeats.get(i).getClient() != null &&
                    standardSeats.get(i).getClient().toString().compareTo(client.toString()) == 0)
                return i;
        return -1;
    }

    /**
     * metoda de cautare a locului VIP rezervat de un anumit client
     *
     * @param show   spectacolul la care este facuta rezervarea
     * @param client clientul care a facut rezervarea
     * @return indicele locului VIP rezervat de client (sau -1 daca nu exista)
     */
    public int findVIPSeatBookedBy(Show show, Client client) {
        Auditorium auditorium = show.getAuditorium();
        ArrayList<VIPSeat> vipSeats = auditorium.getVIPSeats();
        for (int i = 0; i < vipSeats.size(); i++)
            if (vipSeats.get(i).getClient() != null &&
                    vipSeats.get(i).getClient().toString().compareTo(client.toString()) == 0)
                return i;
        return -1;
    }

    /**
     * metoda de cautare a locului rezervat de un anumit client
     *
     * @param show   spectacolul la care este facuta rezervarea
     * @param client clientul care a facut rezervarea
     * @return locul rezervat de client
     */
    public Seat findSeatBookedBy(Show show, Client client) {
        Auditorium auditorium = show.getAuditorium();
        int indexSeat = findStandardSeatBookedBy(show, client);
        if (indexSeat != -1) //am gasit locul standard
        {
            ArrayList<StandardSeat> standardSeats = auditorium.getStandardSeats();
            return standardSeats.get(indexSeat);
        } else {
            indexSeat = findVIPSeatBookedBy(show, client);
            if (indexSeat != -1) //am gasit locul VIP
            {
                ArrayList<VIPSeat> vipSeats = auditorium.getVIPSeats();
                return vipSeats.get(indexSeat);
            }
        }
        return null;
    }

    /**
     * metoda de anulare a unei rezervari
     *
     * @param show   spectacolul la care se anuleaza una din rezervari
     * @param client clientul a carui rezervare va fi anulata
     */
    public void cancelReservationBy(Show show, Client client) {
        Auditorium auditorium = show.getAuditorium();
        int indexSeat = findVIPSeatBookedBy(show, client); //caut un loc VIP rezervat de client
        if (indexSeat != -1) //daca am gasit un loc VIP rezervat de client
        {
            ArrayList<VIPSeat> vipSeats = auditorium.getVIPSeats();
            vipSeats.get(indexSeat).setBooked(false); //locul nu mai este rezervat
            vipSeats.get(indexSeat).setClient(null); //de niciun client
            SortedSet<Client> clients = auditorium.getClients();
            clients.remove(client); //sterg clientul din lista
            System.out.println("A fost anulata rezervarea locului VIP " + (indexSeat + 1) + " de catre " +
                    client.toString());
        } else {
            indexSeat = findStandardSeatBookedBy(show, client); //caut un loc standard rezervat de client
            if (indexSeat != -1) //daca am gasit un loc standard rezervat de client
            {
                ArrayList<StandardSeat> standardSeats = auditorium.getStandardSeats();
                standardSeats.get(indexSeat).setBooked(false); //locul nu mai este rezervat
                standardSeats.get(indexSeat).setClient(null); //de niciun client
                SortedSet<Client> clients = auditorium.getClients();
                clients.remove(client); //sterg clientul din lista
                System.out.println("A fost anulata rezervarea locului standard " + (indexSeat + 1) + " de catre " +
                        client.toString());
            }
        }
    }

    /**
     * metoda de afisare a locurilor rezervate, ordonate lexicografic dupa numele clientului
     *
     * @param show spectacolul vizat
     */
    public void viewAllBookedSeatsAlphabeticallyByClientsName(Show show) {
        Auditorium auditorium = show.getAuditorium();
        Client[] clients = auditorium.getClients().toArray(new Client[0]);
        for (int i = 0; i < clients.length; i++) {
            System.out.print(clients[i].toString() + " a rezervat locul ");
            int indexSeat = findStandardSeatBookedBy(show, clients[i]);
            if (indexSeat != -1) {
                System.out.println("standard " + (indexSeat + 1));
            } else {
                indexSeat = findVIPSeatBookedBy(show, clients[i]);
                System.out.println("VIP " + (indexSeat + 1));
            }
        }
    }

    /**
     * metoda de calculare a incasarilor realizate de un anumit spectacol
     *
     * @param show spectacolul pentru care se calculeaza incasarile
     * @return incasarile realizate
     */
    public double calculateRevenue(Show show) {
        Auditorium auditorium = show.getAuditorium();
        Client[] clients = auditorium.getClients().toArray(new Client[0]);
        double revenue = 0.0;
        for (int i = 0; i < clients.length; i++) //pentru fiecare client
        {
            Seat seat = findSeatBookedBy(show, clients[i]); //caut locul rezervat de acesta
            if (seat != null)
                revenue = revenue + seat.getUndiscountedPrice() -
                        clients[i].getDiscountPercentage() * seat.getUndiscountedPrice() / 100.0;
            //si adaug la incasari pretul platit de client (in functie de pretul locului fara reducere
            // si reducerea aplicata pentru categoria din care face parte clientul)
        }
        return revenue;
    }
}
