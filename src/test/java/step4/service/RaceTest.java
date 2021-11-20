package step4.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.dto.count.Count;
import step4.dto.count.TrialCount;
import step4.dto.name.CarNameGroup;
import step4.dto.record.RecordGroup;

import java.util.Arrays;
import java.util.List;

class RaceTest {

    private CarNameGroup carNameGroup;

    @BeforeEach
    private void init() {
        carNameGroup = new CarNameGroup(Arrays.asList(new String[]{"aa", "bb", "cc"}));
    }

    @ParameterizedTest
    @CsvSource(value = {"3,3", "2,2", "5,5", "6,6"})
    @DisplayName("경기 종료 후 기록 갯수는 경기 시도 횟수와 같다")
    public void startTest(int trial, int expected) {
        Race race = new Race(carNameGroup, new TrialCount(trial));
        List<RecordGroup> recordList = race.start();

        Assertions.assertThat(recordList.size()).isEqualTo(expected);
    }
}