package racingcar.domain;

import racingcar.service.util.Validation;

import java.util.List;

public class GameResultData {

    private final Records records;

    private GameResultData(List<Record> recordList) {
        Validation.nullValueCheck(recordList);

        this.records = Records.create(recordList);
    }

    public static GameResultData of(List<Record> recordList) {
        return new GameResultData(recordList);
    }

    public String getVictoryUsers() {
        return records.getWinner();
    }

}
