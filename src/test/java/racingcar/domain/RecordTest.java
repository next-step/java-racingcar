package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RecordTest {
    private Record step1Record;
    private Record step2Record;

    private Records testRecords;

    @BeforeEach
    void beforeTest() {

        List<Record> testListRecords = new ArrayList<>();

        Name[] names = {new Name("abc"), new Name("def"), new Name("ghi")};
        int[] currentLocation = {1, 2, 3};
        step1Record = new Record(new Cars(currentLocation, names));

        Name[] names2 = {new Name("abc"), new Name("def"), new Name("ghi")};
        int[] currentLocation2 = {2, 3, 4};
        step2Record = new Record(new Cars(currentLocation2, names2));

        testListRecords.add(step1Record);
        testListRecords.add(step2Record);

        testRecords = new Records(testListRecords);
    }

    @Test
    @DisplayName("step이 추가될 때 레코드가 추가 되는 지 테스트")
    void addRecord() {
        // given
        Records records = new Records();

        // when
        records.addRecord(step1Record);
        records.addRecord(step2Record);

        // then
        assertThat(records).isEqualTo(testRecords);
    }

    @Test
    @DisplayName("마지막 record 확인 테스트")
    void lastRecord() {
        // given

        // when
        Record resultRecord = testRecords.lastRecord();

        // then
        assertThat(resultRecord).isEqualTo(step2Record);
    }


}
