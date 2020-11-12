package racingcar;

import java.util.List;

public class ResultView {
    public void print(RacingGame racingGame) {
        List<RaceRecord> raceRecords = racingGame.getRaceRecords();
        for (RaceRecord raceRecord : raceRecords) {
            System.out.println("ROUND " + raceRecord.getRound());
            raceRecord.getRecords().stream()
                    .map(StateUtil::makeStateLine)
                    .forEach(System.out::println);
        }
    }
}
