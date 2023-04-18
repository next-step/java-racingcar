package racing.view;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.List;

public class ResultView {

    private static void println() {
        System.out.print("\n");
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

    private static void printLocation(Cars list) {
        for (int i = 0; i < list.size(); i++) {
            printOnceCar(list.theCar(i));
            println();
        }
    }

    private static void printOnceCar(Car car) {
        for (int i = 0; i < car.location(); i++) {
            printDash();
        }
    }
}
