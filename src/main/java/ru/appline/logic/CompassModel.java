package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CompassModel implements Serializable {

    private static final CompassModel instance = new CompassModel();
    private final Map<Integer, Map<String, String>> compasModel;

    public CompassModel(){
        compasModel = new HashMap<Integer, Map<String, String>>();
    }

    public static CompassModel getInstance() {
        return instance;
    }

    public void add(Map<String, String> compass, int id) {
        compasModel.put(id, compass);
    }

    public Map<String, String> getFromList(int id) {
        return compasModel.get(id);
    }

    public Map<Integer, Map<String, String>> getAll(){
        return compasModel;
    }


}
