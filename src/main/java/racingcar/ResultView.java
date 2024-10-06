package racingcar;

import java.util.List;

public class ResultView {

    private static final String symbol = "-";

    public static void printResult(Race race, int loop) {
        System.out.println("실행결과");
        for (int i = 0; i < loop; i++) {
            race.round();
            printStatusAll(race.getCars());
        }
    }

    private static void printStatusAll(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getStatus(symbol));
        }
        System.out.println();
    }
}
