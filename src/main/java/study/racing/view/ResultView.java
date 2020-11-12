package study.racing.view;

import study.racing.domain.RacingRecord;
import study.racing.domain.RacingRecords;
import study.racing.domain.CarSetInRace;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final String RESULT_HEAD_MESSAGE = "=============실행결과=============";
    private static final String FORWARD_STRING = "-";
    private static final String WINNER_HEAD_MESSAGE = "\n우승자는?\n";
    private static final String WINNER_DELIMITER = ",";

    private ResultView(){}

    public static void showResultHead() {
        System.out.println(RESULT_HEAD_MESSAGE);
    }

    public static void showResult(RacingRecords racingResults) {
        String racingHistory = racingResults.getRecordList().stream()
                .map(racingRecord -> showRoundResult(racingRecord)).collect(Collectors.joining("\n\n"));

        System.out.println(racingHistory);

        String racingWinner = racingResults.getWinners().stream()
                .map(CarSetInRace::getCarName).collect(Collectors.joining(WINNER_DELIMITER));

        System.out.println(WINNER_HEAD_MESSAGE + racingWinner);

    }

    private static String showRoundResult(RacingRecord racingRecord) {
        return racingRecord.getCarSetInRaces().stream()
                .map(carSet ->getRecordByEachCar(carSet.getPosition(), carSet.getCarName())).collect(Collectors.joining("\n"));
    }

    private static String getRecordByEachCar(int position, String carName) {
        return carName + ": " + IntStream.range(0, position)
                .mapToObj(i -> FORWARD_STRING).collect(Collectors.joining());
    }

}
