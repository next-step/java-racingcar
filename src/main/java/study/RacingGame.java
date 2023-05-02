package study;

import java.util.stream.IntStream;

public class RacingGame {

    public static final String HYPHEN = "-";

    public void printStatus(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            System.out.println(HYPHEN.repeat(racingCar.position()));
        }
    }

    public void startRacingGame(int tryCount, RacingCars racingCars) {
        printStatus(racingCars);
        System.out.println(); // 개행

        IntStream.range(0, tryCount).forEach(i -> {
            racingCars.getRacingCars().forEach(RacingCar::moveForwardWhenFourHigher);

            printStatus(racingCars);
            System.out.println(); // 개행
        });
    }

}
