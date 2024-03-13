package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;

public class OutputView {
    private static final String POSITION_DELIMITOR = "-";

    private OutputView() {
        throw new AssertionError();
    }

    public static void printCarPositionByPeriod(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            printCarPosition(car.getPosition());
        }
        System.out.println();
    }

    private static void printCarPosition(int positionNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < positionNumber; i++) {
            stringBuilder.append(POSITION_DELIMITOR);
        }
        System.out.println(stringBuilder);
    }
}
