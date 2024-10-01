package CarRacingGame;

import java.util.Map;

public class PrintView {

    public static void printCars(Map<String, String> cars) {
        cars.forEach((car, position) -> {
            System.out.println(position);  // 각 자동차의 위치 출력
        });
    }
}
