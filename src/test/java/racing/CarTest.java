package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.Car;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    private static final String overFiveinLength = "123456";

    @Test
    @DisplayName("자동차를 생성할 때 5자를 초과할 경우 에러를 발생한다.")
    void constructorTestOverFiveinLengthError() {
        assertThatThrownBy(() -> new Car(0, overFiveinLength)).isInstanceOf(IllegalArgumentException.class);
    }
}
