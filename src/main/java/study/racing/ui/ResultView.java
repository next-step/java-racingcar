package study.racing.ui;

import java.util.List;
import java.util.stream.Collectors;

import study.racing.model.GameResults;
import study.racing.model.RoundResult;
import study.racing.model.car.Car;

public final class ResultView {

    private static final StringBuilder builder = new StringBuilder();
    private static final String DISTANCE_SYMBOL = "-";
    public static final String NAME_DISTANCE_DELIMITER = " : ";
    public static final String WINNERS_DELIMITER = ", ";
    public static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    private ResultView() {
    }

    public static void printResult(GameResults gameResults) {
        gameResults.allRoundResults()
                   .forEach(ResultView::doPrint);
        printWinner(gameResults);
    }

    private static void doPrint(RoundResult roundResult) {
        roundResult.result().getCars().forEach(ResultView::doPrint);
        System.out.println();
    }

    private static void doPrint(Car car) {
        builder.setLength(0);
        builder.append(car.getName() + NAME_DISTANCE_DELIMITER);
        for (int i = 0; i < car.getDistance(); i++) {
            builder.append(DISTANCE_SYMBOL);
        }
        System.out.println(builder);
    }

    private static void printWinner(GameResults gameResults) {
        List<String> winners = convertToName(gameResults);
        System.out.println(String.join(WINNERS_DELIMITER, winners) + WINNER_MESSAGE);
    }

    private static List<String> convertToName(GameResults gameResults) {
        return gameResults.winners().stream()
                          .map(Car::getName)
                          .collect(Collectors.toList());
    }
}
