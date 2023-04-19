package study.race;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import study.race.condition.RaceConditionNumber;

public class TestCarRaceSimple {

    class SuccessCondition implements RaceConditionNumber {
        @Override
        public int fetch() {
            return 4;
        }
    }

    class FailCondition implements RaceConditionNumber {
        @Override
        public int fetch() {
            return 2;
        }
    }


    @Test
    @DisplayName("CarRace 조건 미충족 테스트")
    public void test_race_start_fail() {
        RaceConditionNumber successNumber = new SuccessCondition();
        CarRace race = new CarRace(successNumber);

        assertThrows(IllegalStateException.class, () -> {
            race.run();
        });
    }


    @ParameterizedTest
    @CsvSource({"2, 4", "4, 5", "3, 6"})
    @DisplayName("CarRace 입력 CarEntry 개수 입력 테스트")
    public void test_carrace_carNum_tryNum_input(int entryNum, int raceNum) {
        RaceConditionNumber successNumber = new SuccessCondition();
        CarRace race = new CarRace(successNumber);
        race.ready(entryNum, raceNum);

        assertThat(race.getRaceResult().size()).isEqualTo(entryNum);
    }


    @ParameterizedTest
    @CsvSource({"2, 4", "4, 5", "3, 6"})
    @DisplayName("CarRace 실행 테스트")
    public void test_carrace_run(int entryNum, int raceNum) {
        RaceConditionNumber failNumber = new FailCondition();
        CarRace race = new CarRace(failNumber);
        race.ready(entryNum, raceNum);

        race.run();

        List<CarEntry> entrys = race.getRaceResult();
        assertThat(entrys.size()).isEqualTo(entryNum);

        for (CarEntry entry : entrys) {
            assertThat(entry.getMoveRecord().size()).isEqualTo(raceNum);
        }
    }

}
