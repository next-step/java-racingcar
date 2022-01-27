package racinggame.view;

import java.util.List;
import racinggame.domain.Car;
import racinggame.domain.Winner;

public class ResultView {
    private static final String DELIMITER = ", ";

    public static void printCars(String result) {
        System.out.println(result);
    }

    public static void printWinners(List<Car> cars) {
        List<String> winnerUsers = Winner.findWinner(cars);
        String winners = String.join(DELIMITER, winnerUsers);
        System.out.println("최종 우승자: " + winners);
    }
}
