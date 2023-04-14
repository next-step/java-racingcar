package study.race;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestCarRaceSimple {


    @ParameterizedTest
    @CsvSource({"2, 4", "4, 5", "3, 6"})
    @DisplayName("CarRace 입력 CarEntry 개수 입력 테스트")
    public void test_carrace_carNum_tryNum_input(int entryNum, int raceNum) {
        CarRace race = new CarRace(entryNum, raceNum);

        assertThat(race.getRaceResult().size()).isEqualTo(entryNum);
    }


    @ParameterizedTest
    @CsvSource({"2, 4", "4, 5", "3, 6"})
    @DisplayName("CarRace 실행 테스트")
    public void test_carrace_run(int entryNum, int raceNum) {
        CarRace race = new CarRace(entryNum, raceNum);
        race.run();

        List<CarEntry> entrys = race.getRaceResult();
        assertThat(entrys.size()).isEqualTo(entryNum);

        for (CarEntry entry : entrys) {
            assertThat(entry.getMoveRecord().size()).isEqualTo(raceNum);
        }
    }

}
