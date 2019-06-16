package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {


    @DisplayName("Null 값이 들어갈 경우 IllegalArgumentException")
    @Test
    void throwIllegalArgumentExceptionWhenInputNull() {
        // given and expect
        assertThatThrownBy(() -> Input.of(null)).isInstanceOf(IllegalArgumentException.class);
    }

}
