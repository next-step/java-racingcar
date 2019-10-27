package step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @Test
    void operate() {
        String str = "6 * 3";
        String[] inputArray = str.split(" ");

        Number number = new Number(inputArray[0]);
        number.operate(inputArray[1], inputArray[2]);
        assertThat(number.getValue()).isEqualTo(18);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "6 * *",
            "6 % 6",
            "6 %* 6"
    })
    void throwError(String input) {
        String[] inputArray = input.split(" ");

        Number number = new Number(inputArray[0]);
        assertThatThrownBy(() -> number.operate(inputArray[1], inputArray[2]))
                .isInstanceOf(IllegalArgumentException.class);
    }
}