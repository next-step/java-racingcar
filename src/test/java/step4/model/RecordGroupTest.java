package step4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static step4.Fixture.getAllRecords;

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

    @ParameterizedTest
    @MethodSource("recordsSource")
    @DisplayName("최고거리 우승자를 출력한다. 각(1명, 2명)")
    void winnerPlayer(List<Record> records, int expected) {
        assertThat(new RecordGroup(getAllRecords(records)).getWinners().split(",").length).isEqualTo(expected);
    }

    static Stream<Arguments> recordsSource() {
        List<Record> records1 = new ArrayList<>();
        records1.add(new Record("pobi", 3));
        records1.add(new Record("crong", 4));
        records1.add(new Record("honux", 5));

        List<Record> records2 = new ArrayList<>();
        records2.add(new Record("pobi", 5));
        records2.add(new Record("crong", 4));
        records2.add(new Record("honux", 5));

        return Stream.of(
                Arguments.arguments(records1, 1),
                Arguments.arguments(records2, 2)
        );
    }
}