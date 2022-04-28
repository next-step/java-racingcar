package racingcar;

import java.util.Random;

public class RacingGame {

    private final Random random;
    private int round;
    private int carCount;
    private final Car[] cars;

    public RacingGame(Random random) {
        this.random = random;
        inputCount();
        this.cars = initCars();
    }

    public void play(Car[] cars) {
        while (round-- > 0) {
            playRound(cars);
        }
        System.out.println();
    }

    public Car[] getCars() {
        return cars;
    }

    private void playRound(Car[] cars) {
        for (Car car : cars) {
            int speed = random.nextInt(10);
            car.move(speed);
            OutputView.printRound(speed, car.getDistance());
        }
    }

    private void inputCount() {
        carCount = InputView.inputCars();
        round = InputView.inputRounds();
    }

    private Car[] initCars() {
        Car[] cars = new Car[carCount];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car();
        }

        return cars;
    }


}
