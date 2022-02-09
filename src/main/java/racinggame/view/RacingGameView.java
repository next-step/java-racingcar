package racinggame.view;

import java.util.List;
import racinggame.util.Utils;

public class RacingGameView {
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
