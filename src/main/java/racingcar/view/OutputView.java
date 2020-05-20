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

    public static void printOutWinner(String winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
