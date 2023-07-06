package racingcar.io;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class InputTest {

    @ParameterizedTest
    @ValueSource(strings = {"123", "14"})
    void inputTest_validateNumber(String numbers) {
        assertThat(Input.validateNumber(numbers)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"ag", "", "-1"})
    void inputTest_notValidateNumber(String numbers) {
        assertThat(Input.validateNumber(numbers)).isFalse();
    }
}
