package race.view;

import java.util.List;

public class OutputView {

    public static void printMileages(int numberOfCars, List<String> mileages) {
        for (int carNumber = 0; carNumber < numberOfCars; carNumber++) {
            System.out.println(mileages.get(carNumber));
        }
    }

    public static void printNextLine() {
        System.out.println("\n");
    }
}
