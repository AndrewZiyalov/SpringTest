package ru.appline.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/*
{
"North":"338-23",
"North-East":"24-68",
"East":"69-114",
"East-South":"115-159",
"South":"160-203",
"South-West":"204-248",
"West":"249-294",
"North-West":"295-337"
}
 */

public class CompassModel {
    private static final CompassModel instance = new CompassModel();
    private final Map<Compass, int[]> model;

    public CompassModel(){
        model = new HashMap<Compass, int[]>();
    }

    public static CompassModel getInstance() {
        return instance;
    }

    public void add(Map<String, String> mapCompass) {
        for (Map.Entry<String,String> entry: mapCompass.entrySet()){
            model.put(new Compass(entry.getKey()), dgParser(entry.getValue()));
        }
    }

    private int[] dgParser(String dg){
        final Pattern pattern = Pattern.compile("-");
        String[] strings1 = pattern.split(dg);
        int[] degrees = new int[strings1.length];
        for (int i = 0; i < strings1.length; i++) {
            degrees[i] = Integer.parseInt(strings1[i]);
        }
        return degrees;
    }

    public Compass getFromList(int degree) {
        return getSide(degree);
    }

    public Compass getSide(int degrees) {
        for (Map.Entry<Compass, int[]> entry : model.entrySet()) {
            if (entry.getValue()[0] > entry.getValue()[1]) {
                if ((degrees >= entry.getValue()[0] && degrees < 360) ||
                        (degrees <= entry.getValue()[1] && degrees >= 0)) {
                    return entry.getKey();
                }
            } else if ((degrees >= entry.getValue()[0]) && (degrees <= entry.getValue()[1])) {
                return entry.getKey();
            }
        }
        return null;
    }
}
