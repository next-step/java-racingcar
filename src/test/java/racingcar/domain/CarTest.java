package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @Test
    void 자동차_이름은_5자를_초과할_수_없다() {
        assertThatThrownBy(() -> Car.validateCarName("oneeee"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(ints = {0, 1, 2, 3})
    @ParameterizedTest
    void 난수가_4_미만일_떄_자동차는_전진하지_않는다(int randomNumber) {
        Car car = new Car("race");
        car.moveCarRandomly(randomNumber);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @ParameterizedTest
    void 난수가_4_이상일_떄_자동차는_전진힌다(int randomNumber) {
        Car car = new Car("race");
        car.moveCarRandomly(randomNumber);
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
