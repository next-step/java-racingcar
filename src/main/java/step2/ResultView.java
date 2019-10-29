package step2;

import java.util.List;

public class ResultView {
    private static final String POSITION = "-";

    public static void printStartMessage() {
        System.out.println("실행 결과");
    }

    public static void print(List<Integer> moveResults) {
        for (int moveResult : moveResults) {
            System.out.print(POSITION);
            iteratePrintDash(moveResult);
            newLine();
        }
        newLine();
    }

    private static void iteratePrintDash(int moveResult) {
        for (int i = 0; i < moveResult; i++) {
            System.out.print(POSITION);
        }
    }

    private static void newLine() {
        System.out.println();
    }
}
