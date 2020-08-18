package racing.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {

    @DisplayName("이름이 다섯글자이하일 시 예외 미발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"여섯자리글"})
    public void 이름이다섯자이하인지체크_다섯글자이하_예외미발생하면_통과(String name) {
        assertThatCode(
                () -> Validator.validate(name)
        ).doesNotThrowAnyException();
    }

    @DisplayName("이름이 다섯글자 초과시 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"여섯자리글자"})
    public void 이름이다섯자이하인지체크_여섯글자(String name) {
        assertThatThrownBy(
                () -> Validator.validate(name)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Null or 빈값이 예외발생 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    public void 이름_null또는Empty값_체크(String input) {
        assertThatThrownBy(
                () -> Validator.validate(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
