package step3.view.output;

import java.util.stream.Stream;

public class OutputView {

    static final private String MOVED_PRINTING = "_";

    static public void printingMovement(int movementCount) {
        for (int i = 0; i < movementCount; i++) {
            System.out.print(MOVED_PRINTING);
        }
        System.out.println();
    }

    static public void printingNewLine() {
        System.out.println();
    }
}
