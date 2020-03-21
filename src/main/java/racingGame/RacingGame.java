package racingGame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int cars = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int rounds = scanner.nextInt();

        String[] racingCars = new String[cars];
        Arrays.fill(racingCars, "");

        for (int idx = 0; idx < rounds; idx++) {
            for (int idx2 = 0; idx2 < racingCars.length; idx2++) {
                Random generator = new Random();
                int randomInt = generator.nextInt(10);
                if (randomInt > 4) {
                    racingCars[idx2] += "-";
                }
                System.out.println(racingCars[idx2]);
            }
            System.out.println(" ");
        }
    }
}
