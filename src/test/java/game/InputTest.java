package game;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {

    @ParameterizedTest(name = "음수 또는 숫자 이외의 값이 전달되면 RuntimeException을 반환한다.")
    @ValueSource(strings = {"a", "-1"})
    void input_Number_Of_Cars(String given) {
        System.setIn(new ByteArrayInputStream(given.getBytes()));

        assertThatThrownBy(() -> Input.inputPositiveNumber()).isInstanceOf(RuntimeException.class);
    }
}
