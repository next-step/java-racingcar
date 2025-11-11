package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    void 자동차_처음_위치_0() {
        assertThat(car.getDistance()).isEqualTo(0);
    }


    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 자동차_4이상일_경우_전진(int dis) {
        car.move(dis);

        assertThat(car.getDistance()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    void 자동차_3이하일_경우_움직이지_않는다(int dis) {
        car.move(dis);

        assertThat(car.getDistance()).isEqualTo(0);
    }
}
