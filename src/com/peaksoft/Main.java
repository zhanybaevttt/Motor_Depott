package com.peaksoft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static java.nio.file.StandardOpenOption.CREATE;

public class Main {
    public static GsonBuilder BILDER = new GsonBuilder();
    public static Gson gson = BILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH = Paths.get("./truck");
    public static final Path DRIVER = Paths.get("./driver");

    public static void main(String[] args) {
        // write your code here

        Driver[] seDricer = {
                Driver.seDriver(1, "Asan", ""),
                Driver.seDriver(2, "Uson", ""),
                Driver.seDriver(3, "Askar", ""),
        };
        Truk[] trucks = {
                Truk.createTruck(1, "DAF", "", Status.BASE),
                Truk.createTruck(2, "VOLVO", "", Status.BASE),
                Truk.createTruck(3, "MERSEDES", "", Status.BASE),
        };
        String allTrack = gson.toJson(trucks);
        // System.out.println(allTrack);
        writeFile(allTrack);
        printTrack(WRITE_PATH);
        driverFileWrate(gson.toJson(seDricer));

        //redFile();
       Driver[] drivers=gson.fromJson((driFileREad()),Driver[].class);
       for (Driver d:drivers){
           System.out.println(d);
       }

    }
    public static void printTrack(Path path) {
        System.out.println("INFO  ABOUT   TRACK\n" +
                "----------------------------------\n" +
                "# |  BUS        |   Driver    | State \n " +
                "-------------------------------------");

        Truk[] trucks = gson.fromJson((redFile()), Truk[].class);

        for (Truk truk : trucks) {
            System.out.printf("%-1s", truk.getId());
            System.out.printf("%-10s", truk.getName());
            System.out.printf("%-10s", truk.getDriver());
            System.out.printf("%-10s", truk.getStatus());
            System.out.println("\n------------------------");
        }
    }


    public static void writeFile(String object) {
        Path write = Paths.get(String.valueOf(WRITE_PATH));
        try {
            Files.writeString(write, object, CREATE, StandardOpenOption.WRITE);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private static String redFile() {
        String json = "";
        try {
            FileReader reader = new FileReader(String.valueOf(WRITE_PATH));
            int a;
            while ((a = reader.read()) != -1) {
                json += (char) a;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return json;
    }

    public static void driverFileWrate(String object) {
        Path driver = Paths.get(String.valueOf(DRIVER));
        try {
            Files.writeString(driver, object, CREATE, StandardOpenOption.WRITE);
        } catch (Exception r) {
            r.getMessage();
        }
    }

    private static String driFileREad() {
        String gson = " ";
        try {
            FileReader reader1 = new FileReader(String.valueOf(DRIVER));
            int t;
            while ((t = reader1.read())!=-1){
                gson += (char) t;
            }
        } catch (Exception a) {
            a.getMessage();
        }
        return gson;
    }

}

