package racingcar.service.dto;

import racingcar.utils.Preconditions;

import java.util.List;

public class RoundResult {
    private List<Record> records;

    private RoundResult(List<Record> records) {
        this.records = records;
    }

    public static RoundResult of(List<Record> records) {
        Preconditions.checkNotNull(records, "records는 필수값입니다.");

        return new RoundResult(records);
    }

    public String getFinalWinnerName() {
        return getFinalRound().getRoundWinnerName();
    }

    private Record getFinalRound() {
        return records.get(records.size() - 1);
    }

    public List<Record> getRecords() {
        return records;
    }
}
