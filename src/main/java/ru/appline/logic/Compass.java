package ru.appline.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Compass {
    Map<String, int[]> mapCompas = new HashMap<String, int[]>();

    public Compass(){
        super();
    }

    public Compass(Map<String, String> mapCompas){
        for (Map.Entry<String, String> entry: mapCompas.entrySet()) {
            this.mapCompas.put(entry.getKey(), dgParser(entry.getValue()));
        }
    }

    public Map<String, int[]> getMapCompas() {
        return mapCompas;
    }

    public void setMapCompas(Map<String, String> mapCompas) {
        for (Map.Entry<String, String> entry: mapCompas.entrySet()) {
            this.mapCompas.put(entry.getKey(), dgParser(entry.getValue()));
        }
    }


    public int[] dgParser(String dg){
        final Pattern pattern = Pattern.compile("-");
        String[] strings1 = pattern.split(dg);
        int[] degrees = new int[strings1.length];
        for (int i = 0; i < strings1.length; i++) {
            degrees[i] = Integer.parseInt(strings1[i]);
        }
        return degrees;
    }

    public String getSide(int degrees){
        for (Map.Entry<String, int[]> entry: mapCompas.entrySet()) {
            if (entry.getValue()[0] > entry.getValue()[1]){
                if ((degrees >= entry.getValue()[0] && degrees < 360) ||
                        (degrees <= entry.getValue()[1] && degrees >= 0)){
                    return entry.getKey();
                }
            } else
            if ((degrees >= entry.getValue()[0]) && (degrees <= entry.getValue()[1])){
                return entry.getKey();
            }
        }
        return "side not found";
    }

}
