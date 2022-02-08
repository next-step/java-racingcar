package racinggame.view;

import java.util.List;
import racinggame.dto.RacingDTO;

public class ResultView {

    private static final String DELIMITER = ", ";

    public static void printRace(List<RacingDTO> cars) {
        for (RacingDTO car : cars) {
            printCar(car);
        }
        System.out.println();
    }

    private static void printCar(RacingDTO car) {
        System.out.println(car.carStatus());
    }

    public static void printWinners(List<String> winnerNames) {
        String winners = String.join(DELIMITER, winnerNames);
        System.out.println("최종 우승자: " + winners);
    }
}
