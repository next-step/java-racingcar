package racingcar.ui;

import racingcar.RacingRecord;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class ResultView {

    private static final String RESULT_MESSAGE_PRE = "실행결과\n";
    private static final String RESULT_MESSAGE_WINNER_POST = "가 최종 우승했습니다.";
    private static final String RACING_DISPLAY = "-";
    private static final String CAR_SEPARATOR = " : ";
    private static final String WINNER_SEPARATOR = ", ";
    private static final String LINE_BREAK = "\n";

    private ResultView() {
    }

    public static void showRacingInfo(List<List<RacingRecord>> racingHistory) {
        System.out.print(RESULT_MESSAGE_PRE);
        for (List<RacingRecord> records : racingHistory) {
            System.out.println(getRacingCarsInfo(records));
        }
    }

    private static StringBuffer getRacingCarsInfo(List<RacingRecord> records) {
        StringBuffer stringBuffer = new StringBuffer();
        for (RacingRecord record : records) {
            stringBuffer.append(record.getCar().getName());
            stringBuffer.append(CAR_SEPARATOR);
            stringBuffer.append(getRacingPositionDisplay(record));
            stringBuffer.append(LINE_BREAK);
        }
        return stringBuffer;
    }

    private static StringBuffer getRacingPositionDisplay(RacingRecord record) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < record.getPosition(); i++) {
            stringBuffer.append(RACING_DISPLAY);
        }
        return stringBuffer;
    }

    public static void showRacingWinner(List<RacingRecord> finalRacingHistory) {
        List<String> winners = getRacingWinner(finalRacingHistory);
        System.out.println(String.join(WINNER_SEPARATOR, winners) + RESULT_MESSAGE_WINNER_POST);
    }

    private static List<String> getRacingWinner(List<RacingRecord> racingRecords) {
        int maxPosition = getRacingMaxPosition(racingRecords);
        List<String> winners = new ArrayList<>();
        racingRecords.stream()
                .filter(u -> u.getPosition() == maxPosition)
                .forEach(u -> winners.add(u.getCar().getName()));
        return winners;
    }

    private static int getRacingMaxPosition(List<RacingRecord> finalRacingHistory) {
        return finalRacingHistory.stream()
                .max(Comparator.comparing(RacingRecord::getPosition))
                .orElseThrow(NoSuchElementException::new)
                .getPosition();
    }
}