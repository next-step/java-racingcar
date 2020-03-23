package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputTest {
    private static final String COUNT = "3";
    private static final String TIME = "5";
    private Input input;
    private ByteArrayInputStream byteArrayInputStream;

    @BeforeEach
    void setUp() {
        input = new Input(initInputStream(COUNT));
    }

    @DisplayName("입력값을 검증을 성공한다.")
    @Test
    void read() {
        assertThat(input.read()).isEqualTo(COUNT);

        input = new Input(initInputStream(TIME));
        assertThat(input.read()).isEqualTo(TIME);
    }

    private ByteArrayInputStream initInputStream(String input) {
        byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        return byteArrayInputStream;
    }
}