package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void 자동차_처음_위치_0() {
        Car car = new Car("hojun");
        assertThat(car.getDistance()).isEqualTo(0);
    }


    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void 자동차_4이상일_경우_전진(int dis) {
        Car car = new Car("hojun");
        car.move(dis);

        assertThat(car.getDistance()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,3})
    void 자동차_3이하일_경우_움직이지_않는다(int dis) {
        Car car = new Car("hojun");
        car.move(dis);

        assertThat(car.getDistance()).isEqualTo(0);
    }
}
