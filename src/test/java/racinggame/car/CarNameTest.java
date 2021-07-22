package racinggame.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class CarNameTest {

    @DisplayName("자동차 이름은 5자를 초과하거나 공백이 될 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"123456", ""})
    void car_name_validation() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CarName.of("123456"))
                .withMessage("자동차 이름은 5자를 초과하거나 공백이 될 수 없습니다.");
    }
}
