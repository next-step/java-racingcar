package carracing.domain.car;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {
    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;

    @Test
    void newObject_nameLengthLessThanMin_throwException() {
        final String carNameWithLessThanMin = "a".repeat(Math.max(0, CAR_NAME_MIN_LENGTH)).substring(0, 0);

        assertThatThrownBy(
            () -> new CarName(carNameWithLessThanMin)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void newObject_nameLengthMoreThanMax_throwException() {
        final String carNameWithMoreThanMax = "a".repeat(Math.max(0, CAR_NAME_MAX_LENGTH)) + "a";

        assertThatThrownBy(
            () -> new CarName(carNameWithMoreThanMax)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void newObject_nameLengthMin_throwException() {
        final String carNameWithMinLength = "a".repeat(Math.max(0, CAR_NAME_MIN_LENGTH));
        CarName carName = new CarName(carNameWithMinLength);

        assertThat(carName.name()).isEqualTo(carNameWithMinLength);
    }

    @Test
    void newObject_nameLengthMax_throwException() {
        final String carNameWithMaxLength = "a".repeat(Math.max(0, CAR_NAME_MAX_LENGTH));
        CarName carName = new CarName(carNameWithMaxLength);

        assertThat(carName.name()).isEqualTo(carNameWithMaxLength);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void newObject_nameIsNullAndEmpty_throwException(String nullAndEmptyInput) {
        assertThatThrownBy(
            () -> new CarName(nullAndEmptyInput)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
