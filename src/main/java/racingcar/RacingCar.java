package racingcar;

import java.util.Random;

public class RacingCar {

    public void playRacing(Car[] cars, int cntTry) {
        Random random = new Random();

        for (int i = 0; i < cntTry; i++) {
            for (Car car : cars) {
                if (random.nextInt(10) >= 4) {
                    int cntMove = car.getCntMove();
                    car.setCntMove(cntMove++);
                }
            }
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
