package racingCar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingCar.domain.CarName;

class CarNameTest {
    private static final String LONG_CAR_NAME = "lamborghini";

    @Test
    @DisplayName("자동차의 이름은 5글자를 초과할 수 없다.")
    void test1() {
        assertThatThrownBy(() -> new CarName(LONG_CAR_NAME)).isInstanceOf(IllegalArgumentException.class);
    }

}
