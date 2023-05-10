package study;

import java.util.stream.IntStream;

public class RacingGame {

    public void startRacingGame(int tryCount, RacingCars racingCars) {

        IntStream.range(0, tryCount).forEach(i -> {
            racingCars.moveRacingCars();

            racingCars.printStatus();
            System.out.println(); // 개행
        });
    }

}
