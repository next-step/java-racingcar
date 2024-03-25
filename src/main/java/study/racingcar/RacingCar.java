package study.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingCar{



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int givenCars = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int triedCount = scanner.nextInt();

        List<Car> cars = new ArrayList<>(givenCars);


        for (int i = 0; i < givenCars; i++) {
            cars.add(new Car());

            for (int j = 0; j < triedCount; j++) {
                cars.get(i).move();
            }
            System.out.println();
        }
    }


}
