package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NameTest {

    @DisplayName("자동차 이름이 공백이거나 5자초과일 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "aaaaaa"})
    void name_exception(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Name(name);
        });
    }
}