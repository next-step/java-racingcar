package racingcar;

import calculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RandomBoolTest {
    @ParameterizedTest
    @DisplayName("숫자가 0에서 3 사이면 false를 반환한다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void printFalseIf0to3(int num) {
        assertThat(RandomBool.toBool(num)).isEqualTo(false);
    }

    @ParameterizedTest
    @DisplayName("숫자가 4에서 9 사이면 true를 반환한다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void printTrue(int num) {
        assertThat(RandomBool.toBool(num)).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("숫자가 0에서 9 사이가 아니라면 에러를 발생시킨다.")
    @ValueSource(ints = {-1, 10})
    void name(int num) {
        assertThatThrownBy(() -> RandomBool.toBool(num))
                .isInstanceOf(RuntimeException.class);
    }
}
