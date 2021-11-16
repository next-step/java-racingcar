package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Records {

    private final List<Record> recordList;

    public Records(List<Record> records) {

        this.recordList = records;
    }

    public String getWinner() {
        return getFinalRound().getVictoryUsers();
    }

    public String getRoundWinner(int round) {
        return recordList.get(round-1).getVictoryUsers();
    }

    private Record getFinalRound() {
        return recordList.get(recordList.size() - 1);
    }

    public List<Record> getRecordList() {
        return Collections.unmodifiableList(new ArrayList<>(recordList));
    }

}
