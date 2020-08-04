package step3.view.output;

import java.util.stream.Stream;

public class OutputView {

    final private String MOVED_PRINTING = "_";

    public void printingMovement(int movementCount) {
        Stream.iterate(0, n -> n)
                .limit(movementCount)
                .peek(n -> {
                    System.out.print(MOVED_PRINTING);
                })
                .skip(movementCount - 1)
                .findFirst()
                .ifPresent(n -> {
                    System.out.println(MOVED_PRINTING);
                });
    }
}
