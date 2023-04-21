package racing.view;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.List;

public class ResultView {

    private static void println() {
        System.out.print("\n");
    }

    private static void printName(String input) {
        System.out.print(input + " : ");
    }

    private static void printDash() {
        System.out.print("-");
    }

    public static void printCarsLocations(List<Cars> results) {
        for (int i = 0; i < results.size(); i++) {
            printLocation(results.get(i));
            println();
        }
        println();
    }

    public static void printWinners(List<String> results) {

        for (int i = 0; i < results.size() - 1; i++) {
            System.out.print(results.get(i));
            System.out.print(", ");
        }
        System.out.print(results.get(results.size() - 1));

        System.out.print("가 최종 우승했습니다.");
    }

    private static void printLocation(Cars list) {
        for (int i = 0; i < list.size(); i++) {
            printOnceCar(list.theCar(i));
            println();
        }
    }

    private static void printOnceCar(Car car) {
        printName(car.name());
        for (int i = 0; i < car.location(); i++) {
            printDash();
        }
    }
}
