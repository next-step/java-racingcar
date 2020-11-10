package study.racing.view;

import study.racing.Car;
import study.racing.RacingRecord;
import study.racing.RacingRecords;

import study.racing.SingleRecord;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final String RESULT_HEAD_MESSAGE = "=============실행결과=============";
    private static final String FORWARD_STRING = "-";


    private static final String WINNER_HEAD_MESSAGE = "우승자는?\n";
    private static final String WINNER_DELIMITER = ",";

    public void showResultHead() {
        System.out.println(RESULT_HEAD_MESSAGE);
    }

    public void showResult(RacingRecords racingResults) {
        String racingHistory = racingResults.getRecordList().stream().map(racingRecord -> showRoundResult(racingRecord)).collect(Collectors.joining("\n\n"));
        System.out.println(racingHistory);

        String racingWinner = racingResults.getWinners().stream().map(SingleRecord::getCarName).collect(Collectors.joining(WINNER_DELIMITER));;
        System.out.println(WINNER_HEAD_MESSAGE + racingWinner);

    }

    private String showRoundResult(RacingRecord racingRecord) {
        return racingRecord.getSingleRecords().stream().map(record ->getRecordByEachCar(record.getPosition(), record.getCarName())
        ).collect(Collectors.joining("\n"));
    }

    private String getRecordByEachCar(int position, String carName) {
        return carName + ": " + IntStream.range(0, position)
                .mapToObj(i -> FORWARD_STRING)
                .collect(Collectors.joining());
    }

}
