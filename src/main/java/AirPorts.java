package src.main.java;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AirPorts {

    private ArrayList<String[]> airports = new ArrayList<String[]>();

    public ArrayList<String[]> getAirports(){
        return airports;
    }
    public int getNumberOfRows(){ return airports.size(); }

    private void SortAirports(int column){
        Collections.sort(airports, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[column].compareTo(o2[column]);
            }
        });
    }

    public void SearchAirports(String input, int column){
        BufferedReader reader = null;
        String file = "src/main/resources/airports.csv";
        String line;
        String[] row;
        SearchAlgorithm algorithm = new SearchAlgorithm(input);
        try{
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){
                line.replaceAll("\"", "");
                row = line.split(",");
                if(algorithm.CheckFirstEntry(input, row[column])){
                    airports.add(row);
                }
            }
            SortAirports(column);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
