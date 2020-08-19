package step5.view;

import java.util.List;

import step5.domain.Car;

public class PrintRacingGame {
    public static void printCars(List<Car> cars) {
        for (Car car : cars) {
            print(printCarLocation(car));
            printEnter();
        }
    }

    public static void printReps(int reps) {
        System.out.println(reps + "번째");
    }

    public static void printEnter() {
        System.out.println();
    }

    public static String printCarLocation(Car car) {
        String value = car.getName() + " : ";
        for (int i = 0; i < car.getLocation(); i++) {
            value = value + "-";
        }
        return value;
    }

    public static void print(String value) {
        System.out.print(value);
    }

    public static void printWinner(String value) {
        print(value);
        print("가 최종 우승했습니다.");
        printEnter();
    }

}
