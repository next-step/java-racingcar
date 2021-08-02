package racingCar.ui;

import java.util.ArrayList;
import java.util.List;
import racingCar.domain.RacingCar;

public class PrintService {

    static public void printDistance(int number) {
        String distance = getDistance(number);
        System.out.println(distance);
    }

    static public void printDistanceWithName(int number, String name) {
        String distance = getDistance(number);
        System.out.println(name + " : " + distance);
    }

    private static String getDistance(int number) {
        StringBuilder distance = new StringBuilder();
        for (int i = 0; i < number; i++) {
            distance.append("-");
        }
        return distance.toString();
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printWinners(List<RacingCar> winners) {
        List<String> names = new ArrayList<>();
        for (RacingCar winner : winners) {
            names.add(winner.getCarName());
        }
        String winnerName = String.join(", ", names);
        System.out.println(winnerName + "가 최종 우승했습니다.");
    }

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void showCurrentDrivenDistanceWithName(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            PrintService.printDistanceWithName(car.showDrivenDistance(), car.getCarName());
        }
        PrintService.printEmptyLine();
    }
}
