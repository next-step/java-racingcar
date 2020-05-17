package racingcar.view;

import racingcar.domain.GameResult;

public class OutputView {
    public static void printMessage() {
        System.out.println("\n실행 결과");
    }
    public static void printOut(GameResult gameResult) {
        gameResult.getResult().forEach(System.out::println);
        System.out.println();
    }
}
