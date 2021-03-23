package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step4.domain.Data;
import step4.util.InputValidator;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class inputTest {

    @ParameterizedTest
    @DisplayName("이름 길이 초과")
    @ValueSource(strings = {"bob33,tes423t", "we3ifjwief", "a34123"})
    public void inputNameOver(String names) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->{InputValidator.validate(new Data(names));});
    }

    @ParameterizedTest
    @DisplayName("시도 횟수 음수")
    @CsvSource(value = {"RU,-10", "BOX,-1", "Da,0"})
    public void inputCountMinus(String names, int count) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->{InputValidator.validate(new Data(names, count));});
    }

}
