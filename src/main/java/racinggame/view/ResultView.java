package racinggame.view;

import java.util.List;
import racinggame.dto.RacingDTO;

public class ResultView {
    private static final String FORWARD_SIGN = "-";
    private static final String CAR_COLON = " : ";
    private static final String DELIMITER = ", ";

    public static void printRace(List<RacingDTO> cars) {
        for (RacingDTO car : cars) {
            printCar(car);
        }
        System.out.println();
    }

    private static void printCar(RacingDTO car) {
        String locationBar = getLocationBar(car.getLocation());
        String result = car.getName() + CAR_COLON + locationBar;
        System.out.println(result);
    }

    private static String getLocationBar(int location) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < location; i++) {
            result.append(FORWARD_SIGN);
        }
        return result.toString();
    }

    public static void printWinners(List<String> winnerNames) {
        String winners = String.join(DELIMITER, winnerNames);
        System.out.println("최종 우승자: " + winners);
    }
}
