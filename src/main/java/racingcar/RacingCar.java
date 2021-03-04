package racingcar;

import java.util.Random;

public class RacingCar {

    private static ResultView resultView = new ResultView();

    public void playRacing(Car[] cars, int cntTry) {
        Random random = new Random();

        for (int i = 0; i < cntTry; i++) {
            for (Car car : cars) {
                if (random.nextInt(10) >= 4) {
                    int cntMove = car.getCntMove();
                    car.setCntMove(++cntMove);
                }
            }

            resultView.printResult(cars);
        }
    }

    public void initRacing(int cntCar, int cntTry) {
        Car[] cars = new Car[cntCar];

        for (int i = 0; i < cntCar; i++) {
            cars[i] = new Car(0);
        }

        playRacing(cars, cntTry);
    }
}
