package race.view;

import java.util.List;

public class OutputView {

    public static void printMileages(int numberOfCars, List<String> mileages) {
        for (int j = 0; j < numberOfCars; j++) {
            System.out.println(mileages.get(j));
        }
    }

    public static void printNextLine() {
        System.out.println("\n");
    }
}
