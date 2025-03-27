package racingcar.view;

import racingcar.model.Car;
import racingcar.model.CarName;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.message.Message.WINNING_MESSAGE;

public class OutputView {

    private OutputView() {
    }

    private static final String WINNER_NAME_SEPERATOR = ", ";
    public static final String NAME_POSITION_SEPERATOR = ":";
    public static final String MOVE = "-";
    public static final String SEPERATOR = ",";

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = formatWinnersName(winners);

        print(winnerNames + WINNING_MESSAGE);
    }

    private static String formatWinnersName(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .map(CarName::toString)
                .collect(Collectors.joining(WINNER_NAME_SEPERATOR));
    }
}
