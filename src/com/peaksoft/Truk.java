package com.peaksoft;

public class Truk {
    private int id ;
    private String name;
    private String driver;
    private Status status;

    public Truk(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    public static Truk createTruck(int id , String name,String driver ,Status status){
        Truk truk =new Truk();
        truk.id=id;
        truk.name=name;
        truk.driver=driver;
        truk.status=status;
        return truk;
    }

    @Override
    public String toString() {
        return " " +
                "   " + id +
                "   |  " + name +
                "  |   " + driver +
                "|   " + status ;
}
}
