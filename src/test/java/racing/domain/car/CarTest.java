package racing.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @Test
    void 자동차_이름_길이_확인() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Car("abcdef"));
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    void drive_인자가_4_이상일_경우_자동차는_움직인다(int randomNumber) {
        final Car car = new Car("abc");
        car.drive(randomNumber);
        assertThat(car.getPositionValue()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    void drive_인자가_4_미만일_경우_자동차는_움직이지_않는다(int randomNumber) {
        final Car car = new Car("abc");
        car.drive(randomNumber);
        assertThat(car.getPositionValue()).isEqualTo(0);
    }

    @Test
    void 같은_위치에_있는지_확인() {
        final Car car = new Car("abc",2);
        assertThat(car.isSamePosition(new Position(2))).isTrue();
    }

    @Test
    void 다른_위치에_있는지_확인() {
        final Car car = new Car("abc",2);
        assertThat(car.isSamePosition(new Position(4))).isFalse();
    }
}
