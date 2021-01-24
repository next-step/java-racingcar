package view;

import domain.Car;

import java.util.ArrayList;

public class ResultView {
    public static void printStartSign() {
        System.out.println("실행 결과");
    }

    public static void printCars(ArrayList<Car> cars) {
        for (Car car : cars) {
            printEachCar(car);
        }
        System.out.println();
    }

    public static void printEachCar(Car car) {
        System.out.print(car.getName()+" : ");
        for (int i=0; i<car.getStatus(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinners(ArrayList<String> winners) {
        System.out.println("최종 우승자: ");
        String result = String.join(", ", winners);
        System.out.println(result);
    }
}
