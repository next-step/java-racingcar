package racingcar.view;

import java.util.List;
import racingcar.domain.car.Participants;

public class OutputView {

    private static final String ENTER = "\n";
    private static final String HEAD_MESSAGE = ENTER + "실행 결과";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자: ";

    public static void printMessage(final String message) {
        System.out.print(message);
    }

    public static void printRacingResult(final List<Participants> racingResult) {
        RacingRecord racingRecord = new RacingRecord();

        for (Participants participants : racingResult) {
            racingRecord.appendRecord(participants.getParticipants());
        }

        System.out.println(HEAD_MESSAGE);
        printMessage(racingRecord.getResultRecord());
    }

    public static void printWinner(final String winner) {
        System.out.println(FINAL_WINNER_MESSAGE + winner);
    }
}
