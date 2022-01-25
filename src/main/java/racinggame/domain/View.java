package racinggame.domain;

import java.util.List;

public class View {
    private static final String DELIMITER = ", ";

    public static void printWinnerOfGame(List<String> winners) {
        String result = String.join(DELIMITER, winners);
        System.out.println("최종 우승자: " + result);
    }

    public static void printCarStatus(String carName, int carPosition) {
        String dash = Utils.repeat("-", carPosition);
        System.out.printf("%-5s: %s%n", carName, dash);
    }
}
