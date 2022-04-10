package racingcar.view;

import java.util.List;

public class OutputView {
    private OutputView() throws InstantiationException {
        throw new InstantiationException();
    }

    public static void outputPosition(List<Integer> allPositions) {
        allPositions.forEach(OutputView::outputPosition);
        outputEmptyLine();
    }

    private static void outputPosition(int position) {
        for (int j = 0; j < position; j++) {
            System.out.print("-");
        }

        outputEmptyLine();
    }

    private static void outputEmptyLine() {
        System.out.println();
    }
}
