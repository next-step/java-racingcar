package race;

import java.util.List;

public class ResultView {
    public static PositionPrinter createPositionPrinter() {
        return new PositionPrinter() {
            @Override
            public void printPosition(int carNumber, int position) {
                System.out.println("Car " + String.format("%02d", carNumber + 1) + " : " + "-".repeat(position));
            }
        };
    }

    public static void printRaceStartMessage() {
        System.out.println("\n### Racing Start!!! ###\n");
    }

    public static void printRaceStatus(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            car.printPosition();
        }
        System.out.println();
    }
}