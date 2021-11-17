package study.racing.view;

import java.util.List;

import study.racing.domain.car.Car;
import study.racing.domain.result.GameResults;
import study.racing.domain.result.Round;

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

    private static void doPrint(Round round) {
        round.result()
             .getCars()
             .forEach(ResultView::doPrint);
        System.out.println();
    }

    private static void doPrint(Car car) {
        builder.setLength(0);
        builder.append(car.getName() + NAME_DISTANCE_DELIMITER);
        for (int i = 0; i < car.getDistance().getDistance(); i++) {
            builder.append(DISTANCE_SYMBOL);
        }
        System.out.println(builder);
    }

    private static void printWinner(GameResults gameResults) {
        List<String> winners = gameResults.winners().carNames();
        System.out.println(String.join(WINNERS_DELIMITER, winners) + WINNER_MESSAGE);
    }
}
