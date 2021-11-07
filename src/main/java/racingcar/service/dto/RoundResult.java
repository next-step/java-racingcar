package racingcar.service.dto;

import racingcar.service.domain.Record;
import racingcar.service.model.Records;
import racingcar.utils.Preconditions;

import java.util.List;

public class RoundResult {
    private final Records records;

    private RoundResult(List<Record> recordList) {
        Preconditions.checkNotNull(recordList, "records는 필수값입니다.");

        this.records = Records.from(recordList);
    }

    public static RoundResult of(List<Record> recordList) {
        return new RoundResult(recordList);
    }

    public String getFinalWinnerName() {
        return records.getFinalWinnerName();
    }

    public Records getRecords() {
        return records;
    }
}
