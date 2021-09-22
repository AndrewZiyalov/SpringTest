package ru.appline.logic;

public enum Compass {
    NORTH(0), EAST(90), SOUTH(180), WEST(270);

    private final int degrees;
    Compass(int degrees) {
        this.degrees = degrees;
    }

    public int getDegrees() {
        return this.degrees;
    }

    public Compass fromDegrees(int degrees){
        if (degrees == 0) {
            return Compass.NORTH;
        }
        if (degrees == 90) {
            return Compass.EAST;
        }
        if (degrees == 180) {
            return Compass.SOUTH;
        }
        if (degrees == 270) {
            return Compass.WEST;
        }
        return null;
    }
}
