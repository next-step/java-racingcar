package camp.nextstep.edu.rebellion.racing;

import camp.nextstep.edu.rebellion.racing.rule.RacingRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RecordTest {
    @DisplayName("Entry 경기 기록이 잘 저장되는지 확인")
    @Test
    public void keepTest() {
        // given
        Entry entry = new Entry(Arrays.asList(
                generateCar("1"),
                generateCar("2"),
                generateCar("3")));
        RacingRule alwaysGoRule = () -> true;
        Record record = new Record();
        String expectedLane = "-\n-\n-";

        // when
        entry.move(alwaysGoRule);
        record.keep(entry);
        List<String> result = record.getRecordLane();

        // then
        assertThat(result).containsExactly(expectedLane);
        assertThat(result).hasSize(1);
    }

    private RacingCar generateCar(String name) {
        return new RacingCar(name);
    }
}
