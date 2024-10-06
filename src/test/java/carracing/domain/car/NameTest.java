package carracing.domain.car;

import carracing.exception.RacingCarIllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @DisplayName("자동차 이름은 비어있는 이름을 사용할 수 없다.")
    @ParameterizedTest
    @NullAndEmptySource
    void carNameWithEmptyString(String carName) {
        assertThatThrownBy(() -> Name.from(carName))
                .isInstanceOf(RacingCarIllegalArgumentException.class);
    }

    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"cleancode", "exception", "georgia"})
    void carNameReturnException(String carName) {
        assertThatThrownBy(() ->Name.from(carName))
                .isInstanceOf(RacingCarIllegalArgumentException.class);
    }
}
