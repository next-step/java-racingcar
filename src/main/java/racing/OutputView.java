package racing;

import java.util.ArrayList;

public class OutputView {

    private static final String ROAD = "-";

    public static void showResult(Race race) {
        ArrayList<ArrayList<Integer>> result = race.result();
        System.out.println("실행 결과");
        for (ArrayList<Integer> carsLocation : result) {
            showCarLocations(carsLocation);
            System.out.println();
        }
    }

    private static void showCarLocations(ArrayList<Integer> carsLocation) {
        for (Integer location : carsLocation) {
            String road = ROAD.repeat(Math.max(0, location));
            System.out.println(road);
        }
    }
}
