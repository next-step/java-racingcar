package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.io.Input;

import static org.assertj.core.api.Assertions.*;

public class InputTest {
    @Test
    void inputTest_nameValidation() {
        assertThat(Input.validateCarNames(new String[]{"pobi", "crong", "honux"})).isTrue();
        assertThat(Input.validateCarNames(new String[]{"pobi", "crongcrong", "honux"})).isFalse();
    }

    @Test
    void inputTest_transferStringToList() {
        assertThat(Input.transferStringToList("pobi,crong,honux")).contains("pobi", "crong", "honux");
    }

    @Test
    void inputTest_validateNumber() {
        assertThat(Input.validateNumber("123")).isTrue();
        assertThat(Input.validateNumber("ag")).isFalse();
        assertThat(Input.validateNumber("")).isFalse();
    }
}
