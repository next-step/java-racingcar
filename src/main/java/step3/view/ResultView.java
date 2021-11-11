package step3.view;

import step3.domain.Car;
import step3.domain.GameWinner;
import step3.domain.history.GameHistory;
import step3.domain.history.RoundHistory;

import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
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
        showGameWinner(history);
    }

    private static void showGameWinner(GameHistory history) {
        System.out.println(GameWinner.getGameWinners(history).stream()
                .map(GameWinner::getCarName)
                .collect(Collectors.joining(COMMA + WHITE_SPACE)) + GAME_WINNER_OUTPUT_MESSAGE);
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
