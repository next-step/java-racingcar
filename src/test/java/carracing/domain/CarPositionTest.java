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
        // when
        CarPosition carPosition = new CarPosition(expected);
        // then
        assertThat(carPosition.getNumber()).isEqualTo(expected);
    }

    @DisplayName("유효하지 않은 자동차 위치 정보가 예외를 발생하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -100, -1})
    void checkNegativeNumberTest(int position) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new CarPosition(position)
        ).withMessage(String.format("자동차 위치(%d)는 0 또는 양의 정수가 입력되어야합니다.", position));
    }
}
