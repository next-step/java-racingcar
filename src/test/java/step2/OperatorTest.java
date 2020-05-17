package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorTest {

    @ParameterizedTest
    @CsvSource({ "+", "-", "*", "/" })
    @DisplayName("String 값으로 enum 객체 찾기")
    void findOperatorBySymbol(String param) {
        Operator operator = Operator.findOperatorBySymbol(param);

        assertThat(operator.symbol).isEqualTo(param);
    }
    
    @ParameterizedTest
    @ValueSource(strings = { " ", "1", "a", "%" })
    @DisplayName("사칙연산 기호가 아닌 경우 ")
    void findOperatorBySymbol_withNonOperator(String operator) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Operator.findOperatorBySymbol(operator);
        });
    }

}
