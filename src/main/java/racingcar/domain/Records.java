package racingcar.domain;

import racingcar.service.util.Validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Records {

    private final List<Record> records;

    public Records(List<Record> records) {

        Validation.nullValueCheck(records);

        this.records = records;
    }

    public String getWinner() {
        return getFinalRound().getVictoryUsers();
    }

    private Record getFinalRound() {
        return records.get(records.size() - 1);
    }

    public List<Record> getRecords() {
        return Collections.unmodifiableList(new ArrayList<>(records));
    }

}
