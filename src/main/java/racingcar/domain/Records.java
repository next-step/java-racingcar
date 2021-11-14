package racingcar.domain;

import java.util.List;

public class Records {

    private final List<Record> recordList;

    private Records(List<Record> records) {

        this.recordList = records;
    }

    public static Records create(List<Record> records) {

        return new Records(records);
    }

    public String getWinner() {
        return getFinalRound().getVitoryUsers();
    }

    private Record getFinalRound() {
        return recordList.get(recordList.size() - 1);
    }

}
