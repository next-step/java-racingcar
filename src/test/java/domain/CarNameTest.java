package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {

    @ParameterizedTest
    @NullAndEmptySource
    void carNameNullAndEmpty(String carName) {
        assertThatThrownBy(() -> new CarName(carName))
            .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"gglee1, gglee2, gglee3, gglee4, gglee5"})
    void carNameLengthOver(String carName) {
        assertThatThrownBy(() -> new CarName(carName))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    void carNameIsEqual() {
        CarName carName1 = new CarName("gglee");
        CarName carName2 = new CarName("gglee");

        assertThat(carName1).isEqualTo(carName2);
    }
}
