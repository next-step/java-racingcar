package racingcar.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputsTest {
    Inputs inputs;

    @Test
    void input() {
        inputs = new Inputs("a,b,c", 3);
        assertThat(inputs.getCarNames()).containsExactly("a", "b", "c");
        assertThat(inputs.getForwartCount()).isEqualTo(3);

        inputs = new Inputs("abc", 9);
        assertThat(inputs.getCarNames()).containsExactly("abc");
        assertThat(inputs.getForwartCount()).isEqualTo(9);
    }
}
