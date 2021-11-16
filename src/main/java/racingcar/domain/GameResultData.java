package racingcar.domain;

import racingcar.domain.collection.RecordCollection;
import racingcar.service.util.Validation;

import java.util.List;

public class GameResultData {

    private final Records records;

    private GameResultData(List<Record> recordList) {
        Validation.nullValueCheck(recordList);

        this.records = RecordCollection.create(recordList);
    }

    public static GameResultData of(List<Record> recordList) {
        return new GameResultData(recordList);
    }

    public String getVictoryUsers() {
        return records.getWinner();
    }
    public Records getRecords() {
        return records;
    }

}
