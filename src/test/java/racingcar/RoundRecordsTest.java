package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundRecordsTest {
    @Test
    @DisplayName("레코드 저장하기")
    void addRecord() {
        int recordCount = 1;
        RoundRecords roundRecords = new RoundRecords(recordCount);
        RoundRecord roundRecordExpected = new RoundRecord(new LinkedHashMap<>());

        roundRecords.addRecord(roundRecordExpected);

        RoundRecord roundRecord = roundRecords.getRoundRecordList().get(0);
        assertThat(roundRecord).isEqualTo(roundRecordExpected);
    }
}
