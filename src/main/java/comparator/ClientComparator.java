package comparator;

import models.client_types.Client;

import java.util.Comparator;

public class ClientComparator implements Comparator<Client> {

    /**
     * metoda de comparare (dupa nume si prenume) a doi clienti (pentru TreeSet, SortedSet)
     * concatenez numele si prenumele clientilor si compar String-urile rezultate
     *
     * @param client1 primul client
     * @param client2 al doilea client
     * @return un intreg negativ, daca primul client este lexicografic inaintea celui de-al doilea,
     * 0, daca cei doi clienti au acelasi nume,
     * un intreg pozitiv, daca al doilea client este lexicografic inaintea primului.
     */
    public int compare(Client client1, Client client2) {
        String firstClient;
        String secondClient;
        firstClient = client1.getLastName().concat(client1.getFirstName());
        secondClient = client2.getLastName().concat(client2.getFirstName());
        return firstClient.compareTo(secondClient);
    }
}
