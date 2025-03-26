package racingcar.view;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.message.Message.WINNING_MESSAGE;

public class OutputView {

    private OutputView() {
    }

    private static final String SEPERATOR = ", ";

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = formatWinnersName(winners);

        print(winnerNames + WINNING_MESSAGE);
    }

    private static String formatWinnersName(List<Car> winners) {
        return winners.stream()
                .map(car -> car.getName().getName())
                .collect(Collectors.joining(SEPERATOR));
    }
}
