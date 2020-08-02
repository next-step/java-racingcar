package domain;

import java.util.Random;
import java.util.Scanner;

public class RacingGame {
    private final Random random = new Random();

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNumber = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int time = scanner.nextInt();

        int[] cars = new int[carNumber];

        System.out.println("실행 결과");
        for(int i = 0; i < time; i++) {
            for (int j = 0; j < carNumber; j++) {
                cars[j] += this.move();
                System.out.println(print(cars[j]));
            }
            System.out.println();
        }
    }

    private String print(int number) {
        String movement = "";

        for (int i = 0; i < number; i++) {
            movement = movement.concat("-");
        }

        return movement;
    }

    private int move() {
        int randomNumber = random.nextInt(10);
        return randomNumber > 3 ? 1 : 0;
    }
}
