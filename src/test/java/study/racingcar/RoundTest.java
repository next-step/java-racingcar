package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundTest {
    @DisplayName("1보다 작은 수를 입력할 때 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void exception_occur_when_input_is_less_than_one(int count) {

        assertThatThrownBy(() -> new Round(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0 이상의 값을 입력해 주세요");
    }

    @DisplayName("1보다 같거나 큰 수 입력시 예외 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,10,100})
    void exception_occur_when_input_is_eqaul_or_greater_than_one(int count) {
        assertThatNoException()
                .isThrownBy(() -> new Round(count));
    }
}