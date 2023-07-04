package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputTest {
    @Test
    void inputTest_nameValidation() {
        assertThat(Input.isValidCarName("honux")).isTrue();
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Input.isValidCarName("crongcrong"));
    }

    @Test
    void inputTest_transferStringToList() {
        assertThat(Input.split("pobi,crong,honux")).contains("pobi", "crong", "honux");
    }

    @Test
    void inputTest_validateNumber() {
        assertThat(Input.isValidNumber("123")).isTrue();
        assertThat(Input.isValidNumber("ag")).isFalse();
        assertThat(Input.isValidNumber("")).isFalse();
    }
}
