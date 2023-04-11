package game.view;

import java.util.List;
import java.util.stream.IntStream;

public final class ResultView {

    public static final String POSITION_SYMBOL = "-";

    private ResultView() {
        throw new IllegalCallerException("잘못된 객체 생성입니다.");
    }

    public static void displayExecuteResultMessage() {
        System.out.println("실행 결과");
    }

    public static void displayGameResult(List<Integer> carPositions) {
        for (int carPosition : carPositions) {
            IntStream.range(0, carPosition)
                    .forEach(n -> System.out.print(POSITION_SYMBOL));
            displayNewLine();
        }
        displayNewLine();
    }

    private static void displayNewLine() {
        System.out.println();
    }
}