package racingcar;

import java.util.ArrayList;

public class OutputView {

    public static void printResult(ArrayList<Car> cars) {
        for (Car car: cars) {
            System.out.print(car.name + " : ");
            for (int i = 0; i < car.distance; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static int getMaxScore(ArrayList<Car> cars) {
        int maximum = 0;
        for (Car car: cars) {
            maximum = Math.max(maximum, car.distance);
        }
        return maximum;
    }

    public static void printWinners(ArrayList<Car> cars) {
        int count = 0;
        int maximum = getMaxScore(cars);
        System.out.print("최종 우승자: ");
        for (Car car: cars) {
            if (car.distance != maximum) {
                continue;
            }
            if (count != 0) {
                System.out.print(", ");
            }
            System.out.print(car.name);
            count++;
        }
    }
}
