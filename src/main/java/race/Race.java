package race;

import java.util.Random;
import java.util.Scanner;

public class Race {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfAttempts = scanner.nextInt();

        String[] cars = new String[numberOfCars];

        for (int i = 0; i < numberOfCars; i++) {
            cars[i] = "-";
        }


        for (int i = 0; i < numberOfAttempts; i++) {
            if (i >= 1) {
                for (int j = 0; j < numberOfCars; j++) {
                    Random random = new Random();
                    if (random.nextInt(10) >= 4) {
                        cars[j] += "-";
                    }
                }
            }
            for (int j = 0; j < numberOfCars; j++) {
                System.out.println(cars[j]);
            }
            System.out.println(" ");
        }
    }

}
