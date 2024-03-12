package stiudy;

import java.util.Random;
import java.util.Scanner;

public class RacingGameStudy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = scanner.nextInt();

        System.out.println("시도할 횟수는 몇 회 인가요?");
        int numberOfAttempt = scanner.nextInt();

        String[] cars = new String[numberOfCars];

        start(numberOfCars, cars);

        raceNextRounds(numberOfAttempt, numberOfCars, cars);
    }

    private static void start(int numberOfCars, String[] cars) {
        for (int i = 0; i < numberOfCars; i++) {
            cars[i] = "-";
        }
    }

    private static void raceNextRounds(int numberOfAttempt, int numberOfCars, String[] cars) {
        for (int i = 0; i < numberOfAttempt; i++) { // 1라운드 2라운드 3라운드
            printCarMileage(cars);
            goForward(numberOfCars, cars);
        }
    }

    private static void goForward(int numberOfCars, String[] cars) {
        for (int j = 0; j < numberOfCars; j++) {
            Random random = new Random();
            if (random.nextInt(10) >= 4) {
                cars[j] += "-";
            }
        }
    }

    private static void printCarMileage(String[] cars) {
        for (String car : cars) {
            System.out.println(car); //car0 car1 car2
        }
        System.out.println("\n");
    }

}
