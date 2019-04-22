package models;

import comparator.ClientComparator;
import models.client_types.Client;
import models.seat_types.StandardSeat;
import models.seat_types.VIPSeat;

import java.util.*;

public class Auditorium {
    private int numberOfStandardSeats; //numarul maxim de locuri standard din sala
    private int numberOfVIPSeats; //numarul maxim de locuri VIP din sala
    private ArrayList<StandardSeat> standardSeats; //locurile standard
    private ArrayList<VIPSeat> vipSeats; //locurile VIP
    private SortedSet<Client> clients; //clientii ordonati lexicografic dupa nume si prenume
    private double undiscountedStandardPrice; //pretul unui loc standard fara vreo reducere aplicata
    private double undiscountedVIPPrice; //pretul unui loc VIP fara vreo reducere aplicata

    /**
     * constructor cu parametri
     *
     * @param numberOfStandardSeats numarul de locuri standard din sala
     * @param numberOfVIPSeats      numarul de locuri VIP din sala
     * @param standardSeats         locurile standard
     * @param vipSeats              locurile VIP
     * @param clients               lista clientilor ordonati dupa nume si prenume
     */
    public Auditorium(int numberOfStandardSeats, int numberOfVIPSeats, ArrayList<StandardSeat> standardSeats,
                      ArrayList<VIPSeat> vipSeats, SortedSet<Client> clients) {
        this.numberOfStandardSeats = numberOfStandardSeats;
        this.numberOfVIPSeats = numberOfVIPSeats;
        this.standardSeats = standardSeats;
        this.vipSeats = vipSeats;
        this.clients = clients;
        this.undiscountedStandardPrice = 50; //pretul unui loc standard (fara vreo reducere aplicata) este by default 50
        this.undiscountedVIPPrice = 100; //pretul unui loc VIP (fara vreo reducere aplicata) este by default 100
    }

    /**
     * constructor cu parametri
     *
     * @param undiscountedStandardPrice pretul unui loc standard fara vreo reducere aplicata
     * @param undiscountedVIPPrice      pretul unui loc VIP fara vreo reducere aplicata
     */
    public Auditorium(double undiscountedStandardPrice, double undiscountedVIPPrice) {
        this.undiscountedStandardPrice = undiscountedStandardPrice;
        this.undiscountedVIPPrice = undiscountedVIPPrice;
        this.numberOfStandardSeats = 300; //numarul de locuri standard este by default 300
        this.numberOfVIPSeats = 50; //numarul de locuri VIP este by default 50
        this.standardSeats = new ArrayList<>();
        this.vipSeats = new ArrayList<>();
        this.clients = new TreeSet<>(new ClientComparator());
    }

    /**
     * constructor cu parametri
     *
     * @param numberOfStandardSeats     numarul de locuri standard din sala
     * @param numberOfVIPSeats          numarul de locuri VIP din sala
     * @param undiscountedStandardPrice pretul unui loc standard fara vreo reducere aplicata
     * @param undiscountedVIPPrice      pretul unui loc VIP fara vreo reducere aplicata
     */
    public Auditorium(int numberOfStandardSeats, int numberOfVIPSeats, double undiscountedStandardPrice, double undiscountedVIPPrice) {
        this.numberOfStandardSeats = numberOfStandardSeats;
        this.numberOfVIPSeats = numberOfVIPSeats;
        this.undiscountedStandardPrice = undiscountedStandardPrice;
        this.undiscountedVIPPrice = undiscountedVIPPrice;
        this.standardSeats = new ArrayList<>();
        this.vipSeats = new ArrayList<>();
        this.clients = new TreeSet<>(new ClientComparator());
    }

    /**
     * @return numarul de locuri standard din sala
     */
    public int getNumberOfStandardSeats() {
        return numberOfStandardSeats;
    }

    /**
     * @return numarul de locuri VIP din sala
     */
    public int getNumberOfVIPSeats() {
        return numberOfVIPSeats;
    }

    /**
     * @return locurile standard
     */
    public ArrayList<StandardSeat> getStandardSeats() {
        return standardSeats;
    }

    /**
     * @return locurile VIP
     */
    public ArrayList<VIPSeat> getVIPSeats() {
        return vipSeats;
    }

    /**
     * @return lista ordonata de clienti
     */
    public SortedSet<Client> getClients() {
        return clients;
    }

    /**
     * @param clients noua lista de clienti
     */
    public void setClients(SortedSet<Client> clients) {
        this.clients = clients;
    }

    /**
     * @return pretul unui loc standard fara vreo reducere aplicata
     */
    public double getUndiscountedStandardPrice() {
        return undiscountedStandardPrice;
    }

    /**
     * @return pretul unui loc standard fara vreo reducere aplicata
     */
    public double getUndiscountedVIPPrice() {
        return undiscountedVIPPrice;
    }
}
