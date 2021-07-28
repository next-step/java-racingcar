package racingcar.ui;

import racingcar.RacingRecord;

import java.util.List;

public class ResultView {

    private static final String RESULT_MESSAGE_PRE = "실행결과\n";
    private static final String RESULT_MESSAGE_WINNER_POST = "가 최종 우승했습니다.";
    private static final String RACING_DISPLAY = "-";
    private static final String CAR_SEPARATOR = " : ";
    private static final String WINNER_SEPARATOR = ", ";

    private ResultView() {
    }

    public static void showRacingInfo(List<List<RacingRecord>> racingHistory) {
        System.out.print(RESULT_MESSAGE_PRE);
        for (List<RacingRecord> records : racingHistory) {
            System.out.println(getRacingCarsInfo(records));
        }
        showRacingWinner(racingHistory);
    }

    private static StringBuffer getRacingCarsInfo(List<RacingRecord> records) {
        StringBuffer stringBuffer = new StringBuffer();
        for (RacingRecord record : records) {
            stringBuffer.append(record.getCar().getName());
            stringBuffer.append(CAR_SEPARATOR);
            stringBuffer.append(getRacingPositionDisplay(record));
            stringBuffer.append(System.lineSeparator());
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

    private static void showRacingWinner(List<List<RacingRecord>> racingRecords) {
        List<String> winners = RacingRecord.getRacingWinner(racingRecords);
        System.out.println(String.join(WINNER_SEPARATOR, winners) + RESULT_MESSAGE_WINNER_POST);
    }
}