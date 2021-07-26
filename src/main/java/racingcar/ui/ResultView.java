package racingcar.ui;

import racingcar.RacingRecord;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class ResultView {

    private static final String RESULT_PRE_MESSAGE = "실행결과\n";
    private static final String RACING_DISPLAY = "-";

    private ResultView() {
    }

    public static void showRacingInfo(List<List<RacingRecord>> racingHistory) {
        System.out.print(RESULT_PRE_MESSAGE);
        for (List<RacingRecord> records : racingHistory) {
            for (RacingRecord record : records) {
                System.out.print(record.getCar().getName() + " : ");
                for (int i = 0; i < record.getPosition(); i++) {
                    System.out.print(RACING_DISPLAY);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void showRacingWinner(List<RacingRecord> finalRacingHistory) {
        List<String> winners = getRacingWinner(finalRacingHistory);
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    public static List<String> getRacingWinner(List<RacingRecord> racingRecords) {
        int maxPosition = getRacingMaxPosition(racingRecords);
        List<String> winners = new ArrayList<>();
        racingRecords.stream()
                .filter(u -> u.getPosition() == maxPosition)
                .forEach(u -> winners.add(u.getCar().getName()));
        return winners;
    }

    public static int getRacingMaxPosition(List<RacingRecord> finalRacingHistory) {
        return finalRacingHistory.stream()
                .max(Comparator.comparing(RacingRecord::getPosition))
                .orElseThrow(NoSuchElementException::new)
                .getPosition();
    }
}
