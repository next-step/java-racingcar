package step4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static step4.Fixture.*;

class RecordGroupTest {

    @Test
    @DisplayName("경기 중에 최고 거리를 간 자동차를 찾아낸다.")
    void findMaxDistance() {
        List<Record> records = new ArrayList<>();
        Record record1 = new Record("pobi", 3);
        Record record2 = new Record("crong", 4);
        Record record3 = new Record("honux", 5);

        records.add(record1);
        records.add(record2);
        records.add(record3);

        assertThat(new RecordGroup(getAllRecords(records)).getMaxDistance()).isEqualTo(record3.getDistance());
    }

    @Test
    @DisplayName("최고거리 우승자를 출력한다.(1명)")
    void oneWinnerPlayer() {
        List<Record> records = new ArrayList<>();
        Record record1 = new Record("pobi", 3);
        Record record2 = new Record("crong", 4);
        Record record3 = new Record("honux", 5);

        records.add(record1);
        records.add(record2);
        records.add(record3);

        assertThat(new RecordGroup(getAllRecords(records)).getWinners()).isEqualTo(record3.getPlayer());
    }

    @Test
    @DisplayName("최고거리 우승자를 출력한다.(2명)")
    void twoWinnerPlayer() {
        List<Record> records = new ArrayList<>();
        Record record1 = new Record("pobi", 5);
        Record record2 = new Record("crong", 4);
        Record record3 = new Record("honux", 5);

        records.add(record1);
        records.add(record2);
        records.add(record3);

        assertThat(new RecordGroup(getAllRecords(records)).getWinners().split(",").length).isEqualTo(2);
    }
}