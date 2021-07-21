package StringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class NumericTest {

    @ParameterizedTest
    @DisplayName("null, \"\", 숫자가 아닌 경우 IllegalArgumentException 발생 테스트 ")
    @NullSource
    @EmptySource
    @ValueSource(strings = {"aaa", "가나다"})
    void of(String input) {
        assertThatThrownBy(() -> Numeric.of(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}