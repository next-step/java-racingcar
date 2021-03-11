package racingcar.util;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {

    private static final String DISPLAY_UNIT = "-";
    private static final String CONNECTION_FORMAT = " : ";
    private static final String WINNER_DELIMITER = ", ";

    private ResultView() {
    }

    public static void startGame() {
        System.out.println("\n실행 결과");
    }

    public static void showResult(Car car) {
        StringBuilder positionBuilder = new StringBuilder();
        positionBuilder.append(car.getName()).append(CONNECTION_FORMAT);
        for (int i = 0 ; i < car.getPosition(); i++) {
            positionBuilder.append(DISPLAY_UNIT);
        }
        System.out.println(positionBuilder.toString());
    }

    public static void showWinners(List<String> winnerNames) {
        String names = String.join(WINNER_DELIMITER, winnerNames);
        System.out.println(names +"가 최종 우승했습니다.");
    }

    public static void printNewLine() {
        System.out.println();
    }
}
