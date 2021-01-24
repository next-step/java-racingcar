package racingcar.view;

import racingcar.model.RacingCar;

import java.util.List;

public class RacingGamePrinter {

    private static void printEachCarStatus(String name, int status) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(":");
        for (int j = 0; j < status; j++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder.toString());
    }

    public static void printAllCarStatus(List<RacingCar> cars) {

        for (RacingCar car : cars) {
            String name = car.getName();
            int status = car.getStatus();
            printEachCarStatus(name, status);
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {

        System.out.print("최종 우승자: ");
        String result = String.join(", ", winners);
        System.out.println(result);
    }
}
