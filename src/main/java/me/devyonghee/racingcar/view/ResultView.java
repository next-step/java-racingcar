package me.devyonghee.racingcar.view;

import me.devyonghee.racingcar.utility.Assert;
import me.devyonghee.racingcar.view.dto.TracksHistoryResponse;

import java.io.PrintStream;
import java.util.List;

public final class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String DISTANCE_STRING = "-";

    private final PrintStream output;

    private ResultView(PrintStream output) {
        Assert.notNull(output, "'output' must not be null");
        this.output = output;
    }

    public static ResultView from(PrintStream output) {
        return new ResultView(output);
    }

    public void print(TracksHistoryResponse response) {
        output.println(RESULT_MESSAGE);
        for (List<Integer> distances : response.getDistancesHistory()) {
            for (Integer distance : distances) {
                output.println(DISTANCE_STRING.repeat(distance));
            }
            output.println();
        }
    }
}
