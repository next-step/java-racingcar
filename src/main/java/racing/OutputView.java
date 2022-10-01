package racing;

import java.util.ArrayList;

public class OutputView {
    public static void showResult(Race race) {
        ArrayList<ArrayList<String>> result = race.result();
        System.out.println("실행 결과");
        for (ArrayList<String> carsLocation : result) {
            showCarLocations(carsLocation);
            System.out.println();
        }
    }

    private static void showCarLocations(ArrayList<String> carsLocation) {
        for (String location : carsLocation) {
            System.out.println(location);
        }
    }
}
