package racingcar.view;

import java.util.List;

public class ResultView {

    public void showResult(final List<Integer> currentPositions) {
        currentPositions.forEach(this::printPosition);
        System.out.println();
    }

    private void printPosition(Integer position) {
        StringBuilder currentPosition = new StringBuilder();
        for (int i = 0; i < position; i++) {
            currentPosition.append('-');
        }

        System.out.println(currentPosition);
    }
}
