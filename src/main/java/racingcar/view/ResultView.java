package racingcar.view;

import racingcar.Position;

import java.util.List;

public class ResultView {

    public static final String RESULT_MESSAGE = "-";

    public static void printTitle() {
        printNewLine();
        System.out.println("실행 결과");
    }

    public static void printPlayResults(List<Position> playResults) {
        for (Position position : playResults) {
            System.out.println(resolveResultMessage(position.getPosition()));
        }
        printNewLine();
    }

    private static String resolveResultMessage(int position) {
        return RESULT_MESSAGE.repeat(Math.max(0, position));
    }

    private static void printNewLine() {
        System.out.println();
    }
}
