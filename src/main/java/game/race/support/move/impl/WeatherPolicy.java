package game.race.support.move.impl;

import game.race.support.move.MovePolicy;

public class WeatherPolicy implements MovePolicy {

    public static final int SUNNY = 5;
    public static final int CLODY = 4;
    public static final int WINDY = 3;
    public static final int RAINY = 2;

    // add condition
    @Override
    public boolean move() {
        return false;
    }

    // TBD
    private int getPolicyNumber() {
        return 0;
    }
}
