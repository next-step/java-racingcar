package racingcar;

import java.util.Random;

public class RacingGame {

    private static ResultView resultView = new ResultView();

    public Car[] initRacing(int countCar) {
        Car[] cars = new Car[countCar];

        for (int i = 0; i < countCar; i++) {
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
            int countMove = car.getCountMove();
            car.setCountMove(++countMove);
        }
    }

    public void playRacing(Car[] cars) {
        for (Car car : cars) {
            boolean isRandomOver4 = isRandomOver4();
            updateByRandom(car, isRandomOver4);
        }
    }

    public void startRacing(int countCar, int countTry) {
        Car[] cars = initRacing(countCar);

        for (int i = 0; i < countTry; i++) {
            playRacing(cars);

            resultView.printResult(cars);
        }
    }
}
