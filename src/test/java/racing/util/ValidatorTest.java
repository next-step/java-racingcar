package racing.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    @ParameterizedTest
    @CsvSource(value = {"메롱:true", "다섯글자넘어:false"}, delimiter = ':')
    public void 이름이다섯자이하인지체크(String name, boolean expected) {
        assertThat(Validator.validate(name)).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void 이름_null또는Empty값_체크(String input) {
        assertThatThrownBy(
                () -> Validator.validate(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
