package carracing.model.ui;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import carracing.exception.NameNullPointerException;
import carracing.exception.TryCountMinimumException;
import carracing.exception.TryCountNullPointerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputDtoTest {

    private static final String STRING_NULL = null;
    private static final Integer INTEGER_NULL = null;

    @ParameterizedTest
    @DisplayName("객체생성 성공")
    @CsvSource(value = "hyo:4", delimiter = ':')
    void inputDtoSuccess(String name, Integer tryCount) {
        assertThat(InputDto.of(name, tryCount)).isExactlyInstanceOf(InputDto.class);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름 null 예외처리")
    @ValueSource(ints = {4, 5})
    void nameNullException(Integer tryCount) {
        assertThatExceptionOfType(NameNullPointerException.class)
            .isThrownBy(() -> InputDto.of(STRING_NULL, tryCount));
    }

    @ParameterizedTest
    @DisplayName("이동횟수 null 예외처리")
    @ValueSource(strings = {"dong, hyo"})
    void tryCountNullException(String name) {
        assertThatExceptionOfType(TryCountNullPointerException.class)
            .isThrownBy(() -> InputDto.of(name, INTEGER_NULL));
    }

    @ParameterizedTest
    @DisplayName("이동횟수 1보다 작을 때 예외처리")
    @CsvSource(value = {"hyo:0", "hyo:-1"}, delimiter = ':')
    void tryCountIllegalArgumentException(String name, Integer tryCount) {
        assertThatExceptionOfType(TryCountMinimumException.class)
            .isThrownBy(() -> InputDto.of(name, tryCount));
    }

}
