package race.view;

import java.util.List;

public class OutputView {

    private static final String UNIT_MILEAGE = "-";

    public static void printMileages(List<Integer> positions) {
        for (Integer position : positions) {
            System.out.println(UNIT_MILEAGE.repeat(position));
        }
    }

    public static void printResultStatement() {
        System.out.println("\n");
    }
}
