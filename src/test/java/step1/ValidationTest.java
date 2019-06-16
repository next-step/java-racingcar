package step1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("입력된 문자열의 유효성 검증 테스트")
public class ValidationTest {

    @Test
    @DisplayName("공백 검증 테스트")
    void string_validation_test_for_blank() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    CalculatorApplication.stringValidation("");
                });
    }

    @Test
    @DisplayName("null 검증 테스트")
    void string_validation_test_for_null(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                   CalculatorApplication.stringValidation(null);
                });
    }

    @Test
    @DisplayName("사칙연산 연사자 검증 테스트")
    void operator_type_validation_test() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    CalculatorApplication.operatorTypeValidation("%");
                });
    }
}
