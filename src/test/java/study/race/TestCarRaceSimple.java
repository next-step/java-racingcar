package study.race;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TestCarRaceSimple {


    @ParameterizedTest
    @CsvSource({"2, 4", "4, 5", "3, 6"})
    @DisplayName("CarRace Car 개수 입력 테스트")
    public void test_carrace_carNum_tryNum_input(int carNum, int tryNum) {
        CarRace race = new CarRace(carNum, tryNum);

        assertThat(race.getCars().size()).isEqualTo(carNum);
    }

    
}
