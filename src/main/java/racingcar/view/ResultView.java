package racingcar.view;

import java.util.List;
import racingcar.domain.Cars;

public class ResultView {

    private final static String GAME_WINNER_MESSAGE = "최종 우승자: ";
    private final static String GAME_RESULT_MESSAGE = "실행 결과";
    private final static String DELIMITER = ", ";
    private final static String COLON = ":";
    private final static String DASH = "-";

    public static void printGameStatus(Cars cars) {
        cars.getCars().forEach(car -> {
            String dashes = getDashByMove(car.getPosition());
            System.out.println(car.getName() + COLON + dashes);
        });
    }

    public static void printGameResult(List<String> winners) {
        System.out.println(GAME_WINNER_MESSAGE + String.join(DELIMITER, winners));
    }

    public static void printGameResultMessage() {
        System.out.println(GAME_RESULT_MESSAGE);
    }

    private static String getDashByMove(int move) {
        StringBuilder dash = new StringBuilder();

        for (int i = 0; i < move; i++) {
            dash.append(DASH);
        }
        return dash.toString();
    }
}
