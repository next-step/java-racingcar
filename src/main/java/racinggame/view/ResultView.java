package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.Names;
import racinggame.dto.RoundLog;
import racinggame.dto.RoundLogs;

public class ResultView {

    private static final String DASH = "-";
    private static final String MESSAGE_PLAYER_LOCATION = "%s : %s";
    private static final String MESSAGE_RACE_WINNER = "\n%s가 최종 우승했습니다.";

    private ResultView() {
    }

    public static void currentRecord(RoundLogs roundLogs) {
        for (RoundLog roundLog : roundLogs.getRoundLogs()) {
            locationResult(roundLog);
        }
        System.out.println();
    }

    public static void locationResult(RoundLog roundLog) {
        StringBuilder racingRecord = new StringBuilder();
        for (int i = 0; i < roundLog.getLocation(); i++) {
            racingRecord.append(DASH);
        }
        System.out.print("\n" + String.format(MESSAGE_PLAYER_LOCATION, roundLog.getName(), racingRecord));
    }

    public static void awardRacing(Names winners) {
        System.out.print(String.format(MESSAGE_RACE_WINNER, winners.printNames()));
    }
}
