package racingCar.ui;

import java.util.ArrayList;
import java.util.List;
import racingCar.domain.RacingCar;

public class PrintService {

    private PrintService(){

    }

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    private static String drawDrivenDistance(String type, int number) {
        StringBuilder distance = new StringBuilder();
        for (int i = 0; i < number; i++) {
            distance.append(type);
        }
        return distance.toString();
    }

    public static void printDistanceWithName(int number, String name) {
        System.out.println(name + " : " + drawDrivenDistance("-", number));
    }

    public static void printCurrentDrivenDistanceWithName(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            PrintService.printDistanceWithName(car.getDrivenDistnace(), car.getCarName());
        }
        PrintService.printEmptyLine();
    }

    public static void printWinners(List<RacingCar> winners) {
        List<String> names = new ArrayList<>();
        for (RacingCar winner : winners) {
            names.add(winner.getCarName());
        }
        String winnerName = String.join(", ", names);
        System.out.println(winnerName + "가 최종 우승했습니다.");
    }
}
