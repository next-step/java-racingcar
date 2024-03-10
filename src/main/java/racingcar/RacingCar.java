package racingcar;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RacingCar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNumber = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int count = scanner.nextInt();

        System.out.println("");
        System.out.println("실행 결과");

        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            cars.add(new Car());
        }

        for (int j = 0; j < carNumber; j++) {
            System.out.println(cars.get(j).getPositionWithHyphen());
        }

        System.out.println("");

        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < carNumber; j++) {
                cars.get(j).move(new Random().nextInt(10));
                System.out.println(cars.get(j).getPositionWithHyphen());
            }
            System.out.println("");
        }
    }
}
