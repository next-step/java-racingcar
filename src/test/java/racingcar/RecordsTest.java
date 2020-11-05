package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class RecordsTest {
    @Test
    @DisplayName("레코드 저장하기")
    void addRecord() {
        int recordCount = 1;
        Records records = new Records(recordCount);
        Record recordExpected = new Record(new ArrayList<>());

        records.addRecord(recordExpected);

        Record record = records.getRecordList().get(0);
        assertThat(record).isEqualTo(recordExpected);
    }
}
