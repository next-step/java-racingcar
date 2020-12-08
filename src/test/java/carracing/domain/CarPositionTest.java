package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("자동차 위치를 위한 테스트")
class CarPositionTest {

    @DisplayName("유효한 자동차 위치 정보가 생성되는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 100, Integer.MAX_VALUE})
    void createValidPositionTest(int expected) {
        // When
        CarPosition carPosition = new CarPosition(expected);

        // Then
        assertThat(carPosition.getNumber()).isEqualTo(expected);
    }

    @DisplayName("유효하지 않은 자동차 위치 정보가 예외를 발생하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -100, -1})
    void checkNegativeNumberTest(int position) {
        // When & Then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new CarPosition(position)
        );
    }
}
