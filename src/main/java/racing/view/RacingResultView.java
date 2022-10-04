package racing.view;

import racing.RacingCar;
import racing.RacingCars;

import java.util.List;

public class RacingResultView {

    public static void print(final List<RacingCars> players) {
        System.out.println("\n실행 결과");

        for (final RacingCars cars : players) {
            for (final RacingCar car: cars.getRacingCars()) {
                printMovement(car.getPosition());
            }
            System.out.println();
        }
    }

    private static void printMovement(final int movementCount) {
        System.out.println("-".repeat(Math.max(0, movementCount)));
    }
}
