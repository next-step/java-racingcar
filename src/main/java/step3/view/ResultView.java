package step3.view;

import step3.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultView {
    private static final int INDEX = 0;

    public static void printWinner(List<Car> cars, Integer winnerPosition) {
        for (Car car : cars) {
            if (car.isWinner(winnerPosition)) {
                System.out.print(car.getName() + " ");
            }
        }
        System.out.println(" 가 최종 우승했습니다.");
    }

    public static void printCar(List<Car> cars, Integer time) {

        for (int index = INDEX; index < time; index++) {
            repeatCarObjectWithTimeIndex(cars, index);
            System.out.println();
        }
    }

    private static void repeatCarObjectWithTimeIndex(List<Car> cars, int index) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            repeatPositionWithTimeIndex(car, index);
            System.out.println();
        }
    }

    private static void repeatPositionWithTimeIndex(Car car, int index) {
        for (int i = INDEX; i <= index; i++) {
            printPosition(car.isPositionValue(i));
        }
    }

    private static void printPosition(boolean isPositionValue) {
        if (isPositionValue) {
            System.out.print("- ");
        }
    }
}