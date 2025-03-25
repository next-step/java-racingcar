package step5.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarNameTest {


    @Test
    void create() {
        CarName carName = new CarName("1");
        assertThat(carName.getCarName()).isEqualTo("1");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 자동차의_이름은_공백일_수_없다(String input) {
        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456"})
    void 자동차의_이름은_5자를_초과할_수_없다(String input) {
        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(RuntimeException.class);
    }
}
