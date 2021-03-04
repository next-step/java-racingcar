package racingcar;

import java.util.Random;

public class RacingCar {

    private static ResultView resultView = new ResultView();

    private Car[] initRacing(int cntCar) {
        Car[] cars = new Car[cntCar];

        for (int i = 0; i < cntCar; i++) {
            cars[i] = new Car(0);
        }

        return cars;
    }

    private void updateByRandom(Car car) {
        Random random = new Random ();

        if (random.nextInt(10) >= 4) {
            int cntMove = car.getCntMove();
            car.setCntMove(++cntMove);
        }
    }

    private void playRacing(Car[] cars) {
        for (Car car : cars) {
            updateByRandom(car);
        }
    }

    public void startRacing(int cntCar, int cntTry) {
        Car[] cars = initRacing(cntCar);

        for (int i = 0; i < cntTry; i++) {
            playRacing(cars);

            resultView.printResult(cars);
        }
    }
}
