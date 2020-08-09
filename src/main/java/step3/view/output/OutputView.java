package step3.view.output;

import java.util.stream.Stream;

public class OutputView {

    private static final String MOVED_PRINTING = "_";

    public static void printingMovement(int movementCount) {
        for (int i = 0; i < movementCount; i++) {
            System.out.print(MOVED_PRINTING);
        }
        System.out.println();
    }

    public static void printingNewLine() {
        System.out.println();
    }

    public static void printingText(OutputText outputText) {
        System.out.println(outputText.getQuestion());
    }
}
