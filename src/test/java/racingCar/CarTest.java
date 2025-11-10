package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void 자동차_처음_위치_0() {
        assertThat(new Car().getPosition()).isEqualTo(0);
    }


    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 자동차_4이상일_경우_전진(int dis) {
        Car car = new Car();

        car.move(dis);

        assertThat(car.getPosition()).isEqualTo(dis);
    }
}
