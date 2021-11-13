package step3.view;

import step3.domain.Car;
import step3.domain.GameWinner;
import step3.service.HistoryService;
import step3.domain.RoundHistory;

import java.util.Map;

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

    public static void result(HistoryService history) {
        showGameHistory(history.getAll());
        showGameWinner(GameWinner.of(history));
    }

    private static void showGameWinner(GameWinner gameWinner) {
        System.out.println(String.join(COMMA + WHITE_SPACE,
                gameWinner.getGameWinnersName()) + GAME_WINNER_OUTPUT_MESSAGE);
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
