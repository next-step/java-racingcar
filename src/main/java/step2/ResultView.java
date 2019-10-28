package step2;

import java.util.List;

public class ResultView {
    public ResultView() {
    }

    public void printCarMovement(List<Integer> moveResults) {
        for (int moveResult : moveResults) {
            System.out.print("-");
            iteratePrintDash(moveResult);
            System.out.println();
        }
        System.out.println();
    }

    private void iteratePrintDash(int moveResult) {
        for (int i = 0; i < moveResult; i++) {
            System.out.print("-");
        }
    }
}
