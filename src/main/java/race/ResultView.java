package race;

import java.util.List;

public class ResultView {
    public static void printRaceStartMessage() {
        System.out.println("\n### Racing Start!!! ###\n");
    }

    public static void printRaceStatus(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            System.out.println(String.format("%-5s", car.getName().toString()) + " : " + "-".repeat(car.getPosition().getValue()));
        }
        System.out.println();
    }

    public static void printRaceWinners(List<RacingCar> cars) {
        String[] winners = new String[cars.size()];
        for (RacingCar car : cars) {
            winners[cars.indexOf(car)] = car.getName().toString();
        }
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}