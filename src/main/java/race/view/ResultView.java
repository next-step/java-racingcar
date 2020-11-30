package race.view;


import race.model.Car;
import race.model.Cars;

public class ResultView {
    private final static String BLOCK = "-";

    public static void printRace(int runCount, Cars cars) {
        for (int i = 0; i < runCount; i++) {
            printCarsPosition(i, cars);
            System.out.println();
        }
    }

    private static void printCarsPosition(int runCount, Cars cars) {
        for (Car car : cars.getCars()) {
            int position = car.getPositionInRace(runCount);
            printCarPosition(position);
        }
    }

    public static void printCarPosition(int position) {
        StringBuilder blocks = new StringBuilder();

        for (int i = 0; i < position; i++) {
            blocks.append(BLOCK);
        }
        System.out.println(blocks.toString());
    }
}
