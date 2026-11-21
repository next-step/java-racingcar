package racinggame.winner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    void 자동차_이름() {
        assertThatCode(() -> new Car("test1"))
            .doesNotThrowAnyException();
        assertThatThrownBy(() -> new Car("test123"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
