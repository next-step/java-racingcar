package study.car.race;

public class RacingGame {

    private RacingGame() {
    }

    public static void start() {
        int carCount = InputView.acceptCarCount();
        int tryCount = InputView.acceptTryCount();

        RacingCars racingCars = new RacingCars(carCount);
        for (int i = 0; i < tryCount; i++) {
            racingCars.race();
            ResultView.printResult(racingCars.result());
        }
    }
}
