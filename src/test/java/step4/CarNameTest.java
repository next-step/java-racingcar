package step4;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

public class CarNameTest {

    @Test
    void carName() {
        CarName carName = new CarName("kim");
    }

    @ParameterizedTest
    @NullSource
    void illegalArgumentBecauseCarNameIsNull(String carName) {
        assertThatThrownBy(() -> new CarName(carName))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @EmptySource
    void illegalArgumentBecauseCarNameIsEmpty(String carName) {
        assertThatThrownBy(() -> new CarName(carName))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
