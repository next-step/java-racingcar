package step5;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import step5.model.CarName;
import step5.model.InvalidCarNameException;

public class CarNameTest {

    @Test
    void carName() {
        CarName carName = new CarName("kim");
    }

    @ParameterizedTest
    @NullSource
    void invalidCarNameExceptionBecauseCarNameIsNull(String carName) {
        assertThatThrownBy(() -> new CarName(carName))
            .isInstanceOf(InvalidCarNameException.class);
    }

    @ParameterizedTest
    @EmptySource
    void invalidCarNameExceptionBecauseCarNameIsEmpty(String carName) {
        assertThatThrownBy(() -> new CarName(carName))
            .isInstanceOf(InvalidCarNameException.class);
    }

    @Test
    void invalidCarNameExceptionBecauseCarNameLengthIsLongerThan5() {
        assertThatThrownBy(() -> new CarName("123456"))
            .isInstanceOf(InvalidCarNameException.class);
    }
}
