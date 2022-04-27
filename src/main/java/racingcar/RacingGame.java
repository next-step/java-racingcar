package racingcar;

import java.util.Random;
import java.util.Scanner;

public class RacingGame {

    private final Random random;
    private final Scanner scanner;

    public RacingGame(Random random, Scanner scanner) {
        this.random = random;
        this.scanner = scanner;
    }

    public void play() {
        int carCount = InputView.inputCars(scanner);
        int round = InputView.inputRounds(scanner);

        Car[] cars = new Car[carCount];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car();
        }

        while (round-- > 0) {
            playRound(cars);
        }
    }

    private void playRound(Car[] cars) {
        for (Car car : cars) {
            int speed = random.nextInt(10);
            car.setSpeed(speed);
            car.move();
            OutputView.printRound(speed, car.getDistance());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(new Random(), new Scanner(System.in));
        racingGame.play();
    }

}
