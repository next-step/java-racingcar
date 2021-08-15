package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NameTest {

    @DisplayName("자동차의 이름은 1글자 이상, 5글자 이하입니다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "Adalyn"})
    void carNameLengthIs1to5(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Name(name)).withMessageMatching("자동차의 이름은 1글자 이상, 5글자 이하입니다.");
    }
}
