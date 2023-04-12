package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("자동차 대수가 1이하면 IllegalArgumentException 예외가 발생한다.")
    void testCarLatherThanOne(int number) {
        assertThatThrownBy(()->Validator.validateCarAmount(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 대수는 1 이상이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10})
    @DisplayName("자동차 대수가 1 이상이면 아무 문제 없다.")
    void testCarMoreThanOne(int number) {
        assertThatNoException().isThrownBy(()->Validator.validateCarAmount(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("시도 횟수가 1이하면 IllegalArgumentException 예외가 발생한다.")
    void testTryLatherThanOne(int number) {
        assertThatThrownBy(()->Validator.validateTryAmount(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10})
    @DisplayName("시도 횟수가 1 이상이면 아무 문제 없다.")
    void testTryMoreThanOne(int number) {
        assertThatNoException().isThrownBy(()->Validator.validateTryAmount(number));
    }
}
