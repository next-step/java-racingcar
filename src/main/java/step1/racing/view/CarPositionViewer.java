package step1.racing.view;

import step1.racing.RacingCarHandler;

public class CarPositionViewer {
    public static void printStatus(RacingCarHandler carPositions, String flag) {
        carPositions.racingCars().forEach(car -> System.out.println(car.printStatus(flag)));
    }

    public static void printWinner(RacingCarHandler racingCarHandler) {
        racingCarHandler.getWinners().forEach(car -> System.out.println(car.getName()));
    }
}
