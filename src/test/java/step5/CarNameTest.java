package step5;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import step4.CarName;

public class CarNameTest {

    @Test
    void carName() {
        step4.CarName carName = new step4.CarName("kim");
    }

    @ParameterizedTest
    @NullSource
    void illegalArgumentBecauseCarNameIsNull(String carName) {
        assertThatThrownBy(() -> new step4.CarName(carName))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @EmptySource
    void illegalArgumentBecauseCarNameIsEmpty(String carName) {
        assertThatThrownBy(() -> new step4.CarName(carName))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void illegalArgumentBecauseCarNameLengthIsLongerThan5() {
        assertThatThrownBy(() -> new CarName("123456"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
