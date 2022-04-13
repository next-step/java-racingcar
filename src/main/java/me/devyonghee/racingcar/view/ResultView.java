package me.devyonghee.racingcar.view;

import me.devyonghee.racingcar.utility.Assert;
import me.devyonghee.racingcar.view.dto.TrackHistoryResponse;
import me.devyonghee.racingcar.view.dto.TracksHistoryResponse;
import me.devyonghee.racingcar.view.dto.WinnerResponse;

import java.io.PrintStream;
import java.util.List;

public final class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String DISTANCE_STRING = "-";
    private static final String RACING_RESULT_FORMAT = "%s : %s";

    private static final String WINNER_DELIMITER = ", ";
    private static final String WINNER_RESULT_FORMAT = "%s가 최종 우승했습니다.";


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
        for (List<TrackHistoryResponse> trackHistoryResponses : response.getTrackHistoryResponses()) {
            for (TrackHistoryResponse trackHistoryResponse : trackHistoryResponses) {
                output.println(resultMessage(trackHistoryResponse));
            }
            output.println();
        }
    }

    public void print(WinnerResponse response) {
        output.printf(WINNER_RESULT_FORMAT, String.join(WINNER_DELIMITER, response.getNames()));
    }

    private String resultMessage(TrackHistoryResponse trackHistoryResponse) {
        return String.format(RACING_RESULT_FORMAT, trackHistoryResponse.getName(), distanceMessage(trackHistoryResponse));
    }

    private String distanceMessage(TrackHistoryResponse trackHistoryResponse) {
        return DISTANCE_STRING.repeat(trackHistoryResponse.getDistance());
    }
}
