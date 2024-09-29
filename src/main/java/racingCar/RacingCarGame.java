package racingCar;

import java.util.Random;

public class RacingCarGame {

    private static final int RANDOM_LIMIT = 10;

    public void gameStart(){
        int carCount = InputView.initializeCarCount();
        int tryCount = InputView.initializeTryRacingCount();

        ResultView.printResultMessage();
        racingCar(tryCount, carCount);
    }

    private void racingCar(int tryCount, int carCount) {
        for (int i = 0; i < tryCount; i++) {
            Car[] cars = createRacingCars(carCount);
            ResultView.printCars(cars);
            System.out.println();
        }
    }

    private Car[] createRacingCars(int carCount) {
        Car[] cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car(getRandomInt());
        }
        return cars;
    }

    private int getRandomInt(){
        return new Random().nextInt(RANDOM_LIMIT);
    }
}
