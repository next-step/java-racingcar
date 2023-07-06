package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputTest {
    @Test
    void inputTest_split() {
        assertThat(Input.split("pobi,crong,honux").stream().map(CarName::getName)).contains("pobi", "crong", "honux");
    }

    @Test
    void inputTest_validateNumber() {
        assertThat(Input.isValidNumber("123")).isTrue();
        assertThat(Input.isValidNumber("ag")).isFalse();
        assertThat(Input.isValidNumber("")).isFalse();
    }
}
