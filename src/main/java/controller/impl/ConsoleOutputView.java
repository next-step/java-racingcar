package controller.impl;

import controller.OutputView;
import model.GameResult;

public class ConsoleOutputView implements OutputView {

    private static final String POSITION_STRING_UNIT = "-";

    @Override
    public void printResult(GameResult result) {
        System.out.println();
        result.getCarPositions().stream().map(this::positionToString).forEach(System.out::print);
    }

    private String positionToString(int position) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append(POSITION_STRING_UNIT);
        }
        return builder + "\n";
    }
}
