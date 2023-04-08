package view;

import java.util.List;

import domain.RacingCar;

public class OutputView {
    private static final String POSITION_SEPARATOR = "-";

    public static void printCarsPositionStatus(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            printCarPosition(car.getPosition());
        }
        System.out.println();
    }

    private static void printCarPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(POSITION_SEPARATOR);
        }
        System.out.println();
    }
}
