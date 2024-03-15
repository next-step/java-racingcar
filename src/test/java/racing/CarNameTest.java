package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.CarName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"audi", "tesla"})
    void 자동차이름_입력(String name) {
        CarName carName = new CarName(name);
        assertThat(carName.value()).isEqualTo(name);
    }

    @DisplayName("Null 또는 공백인 경우, 이름이 5자를 초과하는 경우")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", "ferrari"})
    void 적절하지_않은_자동차이름_입력(String name) {
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
