package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.util.ValidationUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilTest {
    private ValidationUtil ValidationUtil;

    @BeforeEach
    void createInstance() {
        ValidationUtil = new ValidationUtil();
    }

    @DisplayName("입력 값이 숫자가 아닌 값 일때 false 반환")
    @ParameterizedTest
    @CsvSource(value = {"1:true" , "d:false" , "1:true"}, delimiter = ':')
    void inputNumber(String input, boolean result) {
        //GIVE

        //WHEN

        //THEN
        assertThat(ValidationUtil.isNumber(input)).isEqualTo(result);
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
