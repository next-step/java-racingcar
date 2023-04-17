package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.RaceCondition;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RaceConditionTest {

    @ParameterizedTest
    @DisplayName("사용자 입력 값이 유효한지 검증한다.")
    @CsvSource(value = {"1,2", "3,4", "5,6"}, delimiter = ',')
    void testValidRaceCondition(int carCount, int raceRound) {
        assertDoesNotThrow(() -> RaceCondition.create(carCount, raceRound));
    }

    @ParameterizedTest
    @DisplayName("사용자 입력 값이 음수이면 exception을 발생시킨다.")
    @CsvSource(value = {"-1,2", "3,-4", "-5,-6"}, delimiter = ',')
    void testInValidRaceCondition(int carCount, int raceRound) {
        assertThatThrownBy(() -> RaceCondition.create(carCount, raceRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양수만 입력할 수 있습니다.");
    }
}
