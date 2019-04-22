package models;

public class Show {
    private String title; //titlul spectacolului
    private String date; //data la care va avea loc spectacolul
    private String time; //ora la care va avea loc spectacolul
    private Auditorium auditorium; //sala de spectacol (locurile, participantii)
    private double undiscountedStandardPrice; //pretul unui loc standard fara vreo reducere aplicata
    private double undiscountedVIPPrice; //pretul unui loc VIP fara vreo reducere aplicata

    /**
     * constructor cu parametri
     *
     * @param title                     titlul spectacolului
     * @param date                      data la care va avea loc spectacolul
     * @param time                      ora la care va avea loc spectacolul
     * @param undiscountedStandardPrice pretul unui loc standard fara vreo reducere aplicata
     * @param undiscountedVIPPrice      pretul unui loc VIP fara vreo reducere aplicata
     */
    public Show(String title, String date, String time, double undiscountedStandardPrice, double undiscountedVIPPrice) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.undiscountedStandardPrice = undiscountedStandardPrice;
        this.undiscountedVIPPrice = undiscountedVIPPrice;
        this.auditorium = new Auditorium(undiscountedStandardPrice, undiscountedVIPPrice);
    }

    /**
     * constructor cu parametri
     *
     * @param title titlul spectacolului
     * @param date  data la care va avea loc spectacolul
     * @param time  ora la care va avea loc spectacolul
     */
    public Show(String title, String date, String time) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.undiscountedStandardPrice = 50; //pretul unui loc standard (fara reducere aplicata) by default este 50
        this.undiscountedVIPPrice = 100; //pretul unui loc VIP (fara reducere aplicata) by default este 50
        this.auditorium = new Auditorium(undiscountedStandardPrice, undiscountedVIPPrice);
    }

    /**
     * @return sala de spectacol (locurile, participantii)
     */
    public Auditorium getAuditorium() {
        return auditorium;
    }

    /**
     * @return reprezentare a unui obiect de tip "Spectacol" sub forma unui String
     */
    @Override
    public String toString() {
        return "Show{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", undiscountedStandardPrice=" + undiscountedStandardPrice +
                ", undiscountedVIPPrice=" + undiscountedVIPPrice +
                '}';
    }
}

