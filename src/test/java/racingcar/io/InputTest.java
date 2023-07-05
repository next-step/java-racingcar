package racingcar.io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputTest {

    @Test
    void inputTest_validateNumber() {
        assertThat(Input.validateNumber("123")).isTrue();
        assertThat(Input.validateNumber("ag")).isFalse();
        assertThat(Input.validateNumber("")).isFalse();
    }
}
