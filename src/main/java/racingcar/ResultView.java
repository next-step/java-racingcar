package racingcar;

import java.util.List;
import java.util.Map;

public class ResultView {

    public static void printResult(Map<Integer, List<Car>> gameRecord) {
        for (int i = 0; i < gameRecord.size(); i++) {
            for (Car car : gameRecord.get(i)) {
                for (int j = 0; j < car.getPosition(); j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
