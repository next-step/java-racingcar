package step3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class CarRace {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int rounds = scanner.nextInt();

        Random random = new Random();

        String[] cars = new String[carCount];
        Arrays.fill(cars, "-");

        for (int i = 0; i < rounds; i++) {
            for (int j = 0; j < carCount; j++) {
                if (random.nextInt(10) >= 4) {
                    cars[j] = cars[j].concat("-");
                }
                System.out.println(cars[j]);
            }
            System.out.println();
        }

    }


}
