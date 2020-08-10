package racing.core;

import java.util.Random;

public class Car {

    private static int CUT_LINE = 4;
    private static int TOTAL = 10;
    private static String TRACK = "-";

    private String route = "";

    public void move(Random random) {
        if (random.nextInt(TOTAL) >= CUT_LINE) {
            route += TRACK;
        }
    }

    public String getRoute() {
        return route;
    }
}
