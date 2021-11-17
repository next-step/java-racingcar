package racingcar.domain;

import racingcar.service.util.Validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Records {

    private final List<Record> recordList;

    public Records(List<Record> records) {

        Validation.nullValueCheck(records);

        this.recordList = records;
    }

    public String getWinner() {
        return getFinalRound().getVictoryUsers();
    }

    private Record getFinalRound() {
        return recordList.get(recordList.size() - 1);
    }

    public List<Record> getRecordList() {
        return Collections.unmodifiableList(new ArrayList<>(recordList));
    }

}
