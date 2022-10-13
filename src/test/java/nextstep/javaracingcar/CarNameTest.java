package nextstep.javaracingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @DisplayName("자동차 이름은 빈 값일 수 없다.")
    @ParameterizedTest
    @NullAndEmptySource
    public void spec01(final String name) {
        assertThatThrownBy(() -> new CarName(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"123456", "12345678", "123456789000"})
    public void spec02(final String name) {
        assertThatThrownBy(() -> new CarName(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름은 5자를 이하를 가질 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"12345", "1234", "12"})
    public void spec03(final String name) {
        assertThatNoException().isThrownBy(() -> new CarName(name));
    }
}
