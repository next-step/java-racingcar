package racing.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Condition;

public class ValidatorUtilsTest {
    @ParameterizedTest
    @CsvSource(value = {"true:test", "false:hanseoCho", "false:javaJmt", "false:cafe24"}, delimiter = ':')
    public void nameFormatCheck(Boolean result, String name) {
        Assertions.assertThat(Condition.checkName(name)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"hanseoCho", "cafe24", "test!!!!@#"})
    public void name(String inputText) {
        Assertions.assertThatExceptionOfType(Exception.class)
                .isThrownBy(() -> {
                    ValidatorUtils.name(inputText);
                });
    }
}
