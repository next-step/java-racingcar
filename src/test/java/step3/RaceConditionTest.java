package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.domain.RaceCondition;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RaceConditionTest {

    @ParameterizedTest
    @DisplayName("사용자 입력 값이 유효한지 검증한다.")
    @MethodSource("getRaceConditions")
    void testValidRaceCondition(int carCount, int raceRound, boolean shouldThrowException) {
        if (shouldThrowException) {
            assertThatThrownBy(() -> RaceCondition.create(carCount, raceRound))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("양수만 입력할 수 있습니다.");
        } else {
            assertDoesNotThrow(() -> RaceCondition.create(carCount, raceRound));
        }
    }

    static Stream<Arguments> getRaceConditions() {
        return Stream.of(
                Arguments.of(-1, 2, true),
                Arguments.of(3, -4, true),
                Arguments.of(5, 6, false)
        );
    }
}
