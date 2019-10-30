package study.firstweek.secondstep;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    private final static String RACING_RESULT_MARKER = "-";

    public void printResult(List<RacingResult> racingResults, int trialCount) {
        System.out.println();
        IntStream.range(0, trialCount).forEach(i -> printMovesPerTrial(racingResults, i));
    }

    private void printMovesPerTrial(List<RacingResult> racingResults, int i) {
        racingResults.forEach(car ->
            printMoves(car.getResults().get(i))
        );
        System.out.println();
    }

    public void printMoves(int num) {
        StringBuilder builder = new StringBuilder();
        IntStream.range(0, num).forEach(i -> builder.append(RACING_RESULT_MARKER));
        System.out.println(builder.toString());
    }
}
