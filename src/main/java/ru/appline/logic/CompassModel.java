package ru.appline.logic;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CompassModel implements Serializable {

    public static final CompassModel instance = new CompassModel();
    private final Map<String, Integer[]> model;

    public CompassModel() {
        model = new HashMap<String, Integer[]>();
        model.put("North", new Integer[]{0, 0});
        model.put("North-East", new Integer[]{1, 89});
        model.put("East", new Integer[]{90, 90});
        model.put("East-South", new Integer[]{91,179});
        model.put("South", new Integer[]{180, 180});
        model.put("South-West", new Integer[]{181,269});
        model.put("West", new Integer[]{270, 270});
        model.put("North-West", new Integer[]{271,359});
    }

    public static CompassModel getInstance() {return instance;}

    public String getSide(int degrees) {
        for (Map.Entry<String, Integer[]> entry : model.entrySet()) {
            if (entry.getValue()[0] <= degrees && entry.getValue()[1] >= degrees) {
                return entry.getKey();
            }
        }
        return null;
    }

}
