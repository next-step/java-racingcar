package step3.view;

import step3.domain.Car;
import step3.repository.GameHistory;
import step3.domain.GameWinner;
import step3.domain.RoundHistory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private static final int LAST_ROUND = 0;
    private static final String WHITE_SPACE = " ";
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String DASH = "-";
    private static final String GAME_START_OUTPUT_MESSAGE = "실행 결과";
    private static final String GAME_WINNER_OUTPUT_MESSAGE = "가 최종 우승했습니다.";

    public static void start() {
        System.out.println(GAME_START_OUTPUT_MESSAGE);
    }

    public static void result(GameHistory history) {
        showGameHistory(history.getAll());
        showGameWinner(history.getGameWinnersBy(LAST_ROUND));
    }

    private static void showGameWinner(List<GameWinner> gameWinners) {
        String winnerNames = gameWinners.stream()
                .map(GameWinner::getName)
                .collect(Collectors.joining(COMMA + WHITE_SPACE));
        System.out.println(winnerNames + GAME_WINNER_OUTPUT_MESSAGE);
    }

    private static void showGameHistory(Map<Integer, RoundHistory> history) {
        for (Integer round : history.keySet()) {
            showRoundHistory(history.get(round));
            System.out.println();
        }
    }

    private static void showRoundHistory(RoundHistory history) {
        history.getCarList()
                .forEach(ResultView::showCarPosition);
    }

    private static void showCarPosition(Car car) {
        System.out.println(car.getName() + WHITE_SPACE + COLON + WHITE_SPACE + repeatDash(car.getPosition()));
    }

    private static String repeatDash(int position) {
        StringBuilder sb = new StringBuilder();
        for (int count = 0; count < position; count++) {
            sb.append(DASH);
        }
        return sb.toString();
    }
}
