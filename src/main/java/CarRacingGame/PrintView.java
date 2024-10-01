package CarRacingGame;

import java.util.Map;

public class PrintView {

    public static void printCars(Map<String, String> cars) {
        cars.forEach((car, position) -> {
            System.out.println(position);
        });
    }
}
