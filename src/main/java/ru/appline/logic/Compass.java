package ru.appline.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Compass {
    String compassSide;

    public Compass(){
        super();
    }

    public Compass(String compassSide){
        this.compassSide = compassSide;
    }

    public String getCompassSide() {
        return compassSide;
    }

    public void setCompassSide(String compassSide) {
        this.compassSide = compassSide;
    }
}