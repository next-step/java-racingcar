package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    @DisplayName("연산 기호 할당(정상)")
    void of(String operator) {
        assertThat(Operator.of(operator)).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"!", "@", "#", "$"})
    @DisplayName("연산 기호 할당(예외)")
    void ofException(String operator) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.of(operator))
                .withMessage("invalid operator : " + operator);
    }
}