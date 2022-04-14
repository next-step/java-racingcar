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
        InputView inputView = new InputView(scanner);
        int carCount = inputView.inputCars();
        int round = inputView.inputRounds();

        Car[] cars = new Car[carCount];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car();
        }

        while (round-- > 0) {
            for (Car car : cars) {
                int speed = random.nextInt(10);
                System.out.print("speed = " + speed + ": ");
                car.setSpeed(speed);
                car.move();
                for (int j = 0; j < car.getDistance(); j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(new Random(), new Scanner(System.in));
        racingGame.play();
    }

}
