package camp.nextstep.edu.rebellion.racing.domain;

import camp.nextstep.edu.rebellion.racing.domain.Entry;
import camp.nextstep.edu.rebellion.racing.domain.RacingCar;
import camp.nextstep.edu.rebellion.racing.domain.Record;
import camp.nextstep.edu.rebellion.racing.domain.SnapShotEntry;
import camp.nextstep.edu.rebellion.racing.rule.RacingRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        // when
        entry.move(alwaysGoRule);
        record.keep(entry);

        List<SnapShotEntry> result = record.getSnapShots();
        SnapShotEntry snapShotEntry = result.get(0);

        // then
        assertAll(
                () -> assertThat(snapShotEntry).isNotNull(),
                () -> assertThat(result).hasSize(1),
                () -> assertThat(snapShotEntry.getCars().stream()
                        .map(car -> car.getName())
                        .collect(Collectors.toList()))
                        .containsExactly("1", "2", "3"),
                () -> assertThat(snapShotEntry.getCars().stream()
                        .mapToInt(car -> car.getPosition())
                        .sum())
                        .isEqualTo(3)
        );
    }

    private RacingCar generateCar(String name) {
        return new RacingCar(name);
    }
}
