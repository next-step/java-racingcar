package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RecordsTest {
    @Test
    @DisplayName("레코드 저장하기")
    void addRecord() {
        int recordCount = 1;
        Records records = new Records(recordCount);

        records.addRecord(null);

        assertThat(records.getRecordList()).hasSize(recordCount);
    }
}
