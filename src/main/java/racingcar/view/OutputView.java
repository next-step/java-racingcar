package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String CAR_MARK = "-";

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printCarPositions(List<Integer> positions) {
        for (int position :
                positions) {
            printCarPosition(position);
        }
        printNewLine();
    }

    private static void printCarPosition(int position) {
        for (int i = 0; i <= position; i++) {
            System.out.print(CAR_MARK);
        }
        System.out.println();
    }
}
