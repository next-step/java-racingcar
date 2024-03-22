package study.racingcar;

import java.util.Random;
import java.util.Scanner;

public class RacingCar{



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int givenCars = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int triedCount = scanner.nextInt();

        Car[] cars = new Car[givenCars];

        for (int i = 0; i < givenCars; i++) {
            cars[i] = new Car();

            for (int j = 0; j < triedCount; j++) {
                if (cars[i].canMove()) {
                    cars[i].move();
                }
            }
            System.out.println();
        }
    }


}
