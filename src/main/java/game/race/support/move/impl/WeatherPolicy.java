package game.race.support.move.impl;

import game.race.support.move.MovePolicy;

public class WeatherPolicy extends MovePolicy {

    public static final int SUNNY = 5;
    public static final int CLODY = 4;
    public static final int WINDY = 3;
    public static final int RAINY = 2;

    // add condition
    @Override
    public int move(int number) {
        return number;
    }

    @Override
    public int getMoveCount(int policyNumber) {
        return policyNumber;
    }

    // TBD
    public static int getPolicyNumber() {
        return 0;
    }
}
