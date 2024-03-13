package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;

public class OutputView {
    private static final String POSITION_DELIMITOR = "-";
    public static void printCarPositionByPeriod(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            printCarPosition(car.getPosition());
        }
        System.out.println();
    }

    private static void printCarPosition(int positionNumber) {
        for (int i = 0; i < positionNumber; i++) {
            System.out.print(POSITION_DELIMITOR);
        }
        System.out.println();
    }
}
