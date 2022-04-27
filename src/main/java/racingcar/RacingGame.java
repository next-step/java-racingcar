package racingcar;

import java.util.Random;
import java.util.Scanner;

public class RacingGame {

    private final Random random;
    private final Scanner scanner;
    private int round;
    private int carCount;
    private final Car[] cars;

    public RacingGame(Random random, Scanner scanner) {
        this.random = random;
        this.scanner = scanner;
        inputCount();
        this.cars = initCars();
    }

    public void play(Car[] cars) {
        while (round-- > 0) {
            playRound(cars);
        }
        System.out.println();
    }

    private void playRound(Car[] cars) {
        for (Car car : cars) {
            int speed = random.nextInt(10);
            car.setSpeed(speed);
            car.move();
            OutputView.printRound(speed, car.getDistance());
        }
    }

    private void inputCount() {
        carCount = InputView.inputCars(scanner);
        round = InputView.inputRounds(scanner);
    }

    private Car[] initCars() {
        Car[] cars = new Car[carCount];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car();
        }

        return cars;
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(new Random(), new Scanner(System.in));
        racingGame.play(racingGame.cars);
    }
}
