package view;

import java.util.List;
import racingCar.RacingCar;
import racingCar.RacingCars;

public class ResultView {
    private final static String AWARD_DELIMITER = ", ";

    public static void printResult(RacingCars cars) {
        for (RacingCar car : cars.findCars()) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public static void printAward(List<String> winnerNames) {
        String winners = String.join(AWARD_DELIMITER, winnerNames);
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
