package racingcar.ui;

import racingcar.domain.Car;
import racingcar.domain.RacingData;
import resource.StringResources;

import java.util.List;

public class ResultView {

    private final static char MOVE_MARK = '-';

    public static void printStart() {
        System.out.println(StringResources.GAME_RESULT);
    }

    public static void printSetResult(RacingData racingData, List<Car> racingCars) {
        for (int i = 0; i < racingData.getNumberOfCars(); i++) {
            printCarStatus(racingCars.get(i));
        }
    }

    public static void printCarStatus(Car car) {

        StringBuilder sb = new StringBuilder(car.getName());
        sb.append(" : ");

        for (int i = 0; i < car.getMoveCount() + 1; i++) {
            sb.append(MOVE_MARK);
        }

        System.out.println(sb.toString());
    }

    public static void lineFeed() {
        System.out.println();
    }

    public static void printWinnerNames(String winnerNames) {
        System.out.println(winnerNames + StringResources.GAME_RESULT_WINNERS);
    }
}
