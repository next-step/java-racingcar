package racingcar;

import racingcar.domain.Car;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.Arrays;
import java.util.Random;

public class RacingCar {

    public static final Random RANDOM = new Random();
    public static final int RANDOM_NUMBER = 4;
    public static final int RANDOM_MAX_NUMBER = 10;
    public static final int CAR_MIN = 0;
    public static final int NUM_MIN = 0;

    public static void racingCar() {
        int car = InputView.inputNumberOfCar();
        int num = InputView.inputNumberOfAttempts();

        validateInput(car, num);
        racing(num, getCars(car));
    }

    public static void validateInput(int car, int num) {
        if (car <= CAR_MIN || num <= NUM_MIN) {
            throw new IllegalArgumentException("차량 수와 시도 횟수는 0보다 큰 수만 입력 가능합니다.");
        }
    }

    private static void racing(int num, Car[] cars) {
        System.out.println("실행 결과");
        for (int i = 0; i < num; i++) {
            moveCar(cars);
            ResultView.viewRacingCar(cars);
        }
    }

    public static void moveCar(Car[] cars) {
        for (int j = 0; j < cars.length; j++) {
            if (cars[j].getMoveCount() == 0) {
                cars[j].reset();
                continue;
            }
            if (getRandomNumber() >= RacingCar.RANDOM_NUMBER) {
                cars[j].move();
            }
        }
    }

    public static Car[] getCars(int car) {
        Car[] cars = new Car[car];
        for (int i = 0; i < car; i++) {
            cars[i] = new Car();
        }
        return cars;
    }

    public static int getRandomNumber() {
        return RANDOM.nextInt(RANDOM_MAX_NUMBER);
    }
}
