package racingcar;

import java.util.Random;

public class RacingCar {

    private static ResultView resultView = new ResultView();

    public Car[] initRacing(int cntCar) {
        Car[] cars = new Car[cntCar];

        for (int i = 0; i < cntCar; i++) {
            cars[i] = new Car(0);
        }

        return cars;
    }

    public boolean isRandomOver4() {
        Random random = new Random();

        return random.nextInt(10) >= 4;
    }

    public void updateByRandom(Car car, boolean isRandomOver4) {
        if (isRandomOver4) {
            int cntMove = car.getCntMove();
            car.setCntMove(++cntMove);
        }
    }

    public void playRacing(Car[] cars) {
        for (Car car : cars) {
            boolean isRandomOver4 = isRandomOver4();
            updateByRandom(car, isRandomOver4);
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
