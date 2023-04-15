package racing;

import java.util.List;

public class ResultView {

    static void printCarsLocation(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            printLocation(cars.get(i).getLocation());
        }
        System.out.println("\n");
    }

    private static void printLocation(int input) {
        for (int i = 0; i < input; i++) {
            System.out.print("-");
        }
        System.out.println("\n");
    }
}
