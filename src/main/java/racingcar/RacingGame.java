package racingcar;

import java.util.Random;
import java.util.Scanner;

public class RacingGame {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int round = scanner.nextInt();

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

}
