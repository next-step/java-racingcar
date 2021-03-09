package racingcar.util;

import racingcar.domain.Car;

public class ResultView {

    private static final String DISPLAY_UNIT = "-";

    private ResultView() {
    }

    public static void startGame() {
        System.out.println("\n실행 결과");
    }

    public static void showResult(Car car) {
        StringBuilder positionBuilder = new StringBuilder();
        for (int i = 0 ; i < car.getPosition(); i++) {
            positionBuilder.append(DISPLAY_UNIT);
        }
        System.out.println(positionBuilder.toString());
    }

    public static void endGame() {
        System.out.println("\n게임 종료");
    }

    public static void printNewLine() {
        System.out.println();
    }
}
