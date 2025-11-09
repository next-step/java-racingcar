package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {

    @Test
    void 전진_조건_미만이면_정지() {
        Car car = new Car();

        car.move(3);

        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    void 전진_조건_이상이면_1칸_전진() {
        Car car = new Car();

        car.move(4);

        assertThat(car.getDistance()).isEqualTo(1);
    }
}
