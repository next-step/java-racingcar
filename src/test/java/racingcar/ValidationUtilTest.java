package racingcar;

import calculator.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.ValidationUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ValidationUtilTest {
    private ValidationUtil ValidationUtil;

    @BeforeEach
    void createInstance() {
        ValidationUtil = new ValidationUtil();
    }

    @DisplayName("입력 값이 숫자가 아닌 값 일때 Exception 반환")
    @ParameterizedTest
    @ValueSource(strings = {"d"})
    void inputNumber(String input) {
        //GIVE

        //WHEN

        //THEN
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> ValidationUtil.isNumCheck(input));

    }

    @DisplayName("입력 값이 5글자가 넘는 값 일때 false 반환")
    @ParameterizedTest
    @CsvSource(value = {"test1234:false" , "test1:true" , "good:true"}, delimiter = ':')
    void isNameLength(String input, boolean result) {
        //GIVE

        //WHEN

        //THEN
        assertThat(ValidationUtil.isNameLength(input)).isEqualTo(result);
    }
}
