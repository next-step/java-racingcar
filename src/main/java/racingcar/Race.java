package racingcar;

import java.util.Random;

public class Race {

    public static void execute() {
        Car car = new Car();
        car.carNames = InputView.getName();
        car.cars = new int[car.carNames.length];
        if (!InputView.checkCarName(car.carNames)) {
            System.out.println("자동차 이름은 5자를 초과할 수 없습니다.");
            return;
        }
        car.times = InputView.getTimes();
        car.repeatGame();
        OutputView.printWinners(car.carNames, car.cars);
    }

    public static int getRandomNumber() {
        int randomNumber = new Random().nextInt(10);
        return randomNumber;
    }

    public static void compareWithFour(int[] cars, int idx, int randomNumber) {
        if (randomNumber >= 4) {
            cars[idx]++;
        }
    }
}
