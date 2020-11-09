package study.racing.view;

import study.racing.Car;
import study.racing.RacingRecord;
import study.racing.RacingRecords;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final String RESULT_HEAD_MESSAGE = "=============실행결과=============";
    private static final String FORWARD_STRING = "-";

    public void showResultHead() {
        System.out.println(RESULT_HEAD_MESSAGE);
    }

    public void showResult(RacingRecords racingResults) {
        String test = racingResults.getRecordList().stream().map(racingRecord -> showRoundResult(racingRecord)).collect(Collectors.joining("\n\n"));
        System.out.println(test);
    }

    private String showRoundResult(RacingRecord racingRecord) {
        return racingRecord.getPositionList().stream().map(positionIndex -> getRecordByEachCar(positionIndex)).collect(Collectors.joining("\n"));
    }

    private String getRecordByEachCar(int position) {
        return IntStream.range(0, position)
                .mapToObj(i -> FORWARD_STRING)
                .collect(Collectors.joining());
    }

}
