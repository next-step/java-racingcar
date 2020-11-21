package racingcar.view;

import racingcar.util.StringUtil;
import racingcar.domain.RaceRecord;
import racingcar.domain.RacingGame;

import java.util.List;

public class ResultView {
    public void print(RacingGame racingGame) {
        List<RaceRecord> raceRecords = racingGame.getRaceRecords().getRaceRecords();
        for (RaceRecord raceRecord : raceRecords) {
            System.out.println("ROUND " + raceRecord.getRound());
            raceRecord.getRecordsWithCarName()
                    .forEach((key, value) -> System.out.printf("%s : %s \n", key, StringUtil.makeStateLine(value)));
        }
        System.out.println(racingGame.getRaceRecords().getWinner() + "가 우승했습니다.");
    }
}
