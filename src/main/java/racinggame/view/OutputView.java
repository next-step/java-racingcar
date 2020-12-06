package racinggame.view;

import racinggame.domain.GameResult;

import java.util.List;
import java.util.stream.IntStream;

public class OutputView {
    private static final String POSITION_TEXT = "-";

    public static void print(final List<GameResult> gameResults) {
        gameResults.forEach(gameResult -> {
            printCarsPosition(gameResult.getPositions());
            System.out.println();
        });
    }

    private static void printCarsPosition(List<Integer> positions) {
        positions.forEach(position -> {
            printCarPosition(position);
            System.out.println();
        });
    }

    private static void printCarPosition(int position) {
        IntStream.range(0, position).forEach(p -> System.out.print(POSITION_TEXT));
    }
}
