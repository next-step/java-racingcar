package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RecordsTest {
    @Test
    @DisplayName("레코드 저장하기")
    void addRecord() {
        int recordNum = 3;
        Records records = new Records(recordNum);

        IntStream.range(0, recordNum)
                .forEach(idx -> records.addRecord(null));

        assertThat(records.getRecordList()).hasSize(3);
    }
}
