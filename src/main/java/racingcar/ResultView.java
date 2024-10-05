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
            printStatus(car.getPosition());
        }
        System.out.println();
    }

    private static void printStatus(int position) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < position; i++) {
            sb.append(symbol);
        }
        System.out.println(sb);
    }
}
