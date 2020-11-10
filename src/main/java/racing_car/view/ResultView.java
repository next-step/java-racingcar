package racing_car.view;

import racing_car.domain.LabRecord;
import racing_car.domain.RacingRecord;
import racing_car.domain.Record;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final String RACING_DASH = "-";
    private static final String USERS_DELIMITER = ", ";
    private static final String NOTI_WINNER_USER_MESSAGE_FORMAT = "%s가 최종 우승 했습니다.";
    private static final String LAB_STATE_MESSAGE_FORMAT = "%s : %s";

    public static void drawRacingResult(RacingRecord racingRecord) {
        System.out.println(buildRacingResultString(racingRecord));
    }

    private static String buildRacingResultString(RacingRecord racingRecord) {
        StringBuilder sb = new StringBuilder();
        sb.append(buildRacingStateString(racingRecord));
        sb.append(System.lineSeparator());
        sb.append(buildWinnerMessage(racingRecord));
        return sb.toString();
    }

    private static String buildRacingStateString(RacingRecord racingRecord) {
        return racingRecord.toLabRecordList()
                .stream()
                .map(ResultView::buildLabStateString)
                .collect(
                        Collectors.joining(System.lineSeparator() + System.lineSeparator()));
    }

    private static String buildWinnerMessage(RacingRecord racingRecord) {
        return
                String.format(
                        NOTI_WINNER_USER_MESSAGE_FORMAT,
                        buildWinnerString(racingRecord));
    }

    private static String buildWinnerString(RacingRecord racingRecord) {
        return racingRecord.getFinalLabWinnersName()
                .stream()
                .collect(
                        Collectors
                                .joining(USERS_DELIMITER)
                );
    }

    private static String buildLabStateString(LabRecord labRecord) {
        return labRecord.toRecordList()
                .stream()
                .map(ResultView::buildRecordStateString)
                .collect(
                        Collectors
                                .joining(System.lineSeparator())
                );
    }

    private static String buildRecordStateString(Record record) {
        return String.format(
                LAB_STATE_MESSAGE_FORMAT,
                record.getName(),
                buildLocationString(record.getLocation())
        );
    }

    private static String buildLocationString(int location) {
        StringBuilder sb = new StringBuilder();
        IntStream
                .range(0, location)
                .forEach(i -> sb.append(RACING_DASH));
        return sb.toString();
    }

}
