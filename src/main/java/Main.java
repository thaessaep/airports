package src.main.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        int column = -1;

        try{
            column = Integer.parseInt(args[0]);
        }
        catch (Exception e){
            FileInputStream fis;
            Properties properties = new Properties();
            try{
                fis = new FileInputStream("src/main/resources/pom.properties");
                properties.load(fis);
                column = Integer.parseInt(properties.getProperty("standard.value"));
            }
            catch (IOException ioException){
                ioException.printStackTrace();
            }
        }
        System.out.print("Введите строку: ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        while(input == ""){
            System.out.print("Неверный формат. Попробуйте ещё раз: ");
            input = in.nextLine();
        }
        TimeTracker timeTracker = new TimeTracker();
        AirPorts airPorts = new AirPorts();
        airPorts.SearchAirports(input, column);
        long totalTime = timeTracker.getTotalTime();
        ArrayList<String[]> airportsList = airPorts.getAirports();
        for(String[] rows: airportsList){
            for(String row: rows){
                System.out.print(row);
            }
            System.out.println();
        }
        System.out.println("Количетсво найденных строк: " + airPorts.getNumberOfRows());
        System.out.printf("Время, затраченное на поиск: %d мс", totalTime);


    }
}
