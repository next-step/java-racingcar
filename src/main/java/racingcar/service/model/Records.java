package racingcar.service.model;

import racingcar.service.domain.Record;
import racingcar.utils.Preconditions;

import java.util.List;

public class Records {
    private final List<Record> recordList;

    private Records(List<Record> recordList) {
        Preconditions.checkNotNull(recordList, "recordList 필수값입니다.");

        this.recordList = recordList;
    }

    public static Records from(List<Record> recordList) {
        return new Records(recordList);
    }

    public String getFinalWinnerName() {
        return getFinalRound().getFinalWinnerName();
    }

    private Record getFinalRound() {
        return recordList.get(recordList.size() - 1);
    }

    public List<Record> getRecordList() {
        return recordList;
    }
}
