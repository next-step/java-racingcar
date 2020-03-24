package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class InputTest {
    private static final String CAR_NAMES = "pobi,crong,honux";
    private static final String TIME = "5";
    private Input input;
    private ByteArrayInputStream byteArrayInputStream;

    @DisplayName("입력값을 검증을 성공한다.")
    @Test
    void read() {
        input = new Input(initInputStream(CAR_NAMES));
        assertThat(input.read()).isEqualTo(CAR_NAMES);

        input = new Input(initInputStream(TIME));
        assertThat(input.read()).isEqualTo(TIME);
    }

    @DisplayName("입력값이 공백일 경우 예외 발생을 성공한다.")
    @Test
    void valid() {
        final String BLANK = " ";
        input = new Input(initInputStream(BLANK));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> input.read()
        );
    }

    private ByteArrayInputStream initInputStream(String input) {
        byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        return byteArrayInputStream;
    }
}