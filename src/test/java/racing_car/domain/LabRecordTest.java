package racing_car.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LabRecordTest {

    @DisplayName("랩 승리자 레코드 추출 테스트")
    @Test
    void test() {
        List<Record> recordList = new ArrayList<>();
        recordList.add(new Record("철수", 1));
        recordList.add(new Record("자바", 2));
        recordList.add(new Record("영희", 4));
        recordList.add(new Record("파이썬", 4));

        LabRecord labRecord = new LabRecord(recordList);

        List<Record> winnersRecords = labRecord.findWinnersRecords();

        assertAll(() ->
        {
            assertThat(winnersRecords.size()).isEqualTo(2);
            for (Record winnersRecord : winnersRecords) {
                assertThat(winnersRecord.getLocation()).isEqualTo(4);
            }
        });
    }
}
