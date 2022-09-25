package racing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = { 5, 6, 7, 8 })
    void 자동차는_조건에_맞으면_움직일_수_있다(int bound) {
        Car car = new Car(limit -> bound);
        car.move();
        assertThat(car.currentPosition()).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void 자동차는_조건에_안맞으면_움직이지_않는다(int bound) {
        Car car = new Car(limit -> bound);
        car.move();
        assertThat(car.currentPosition()).isEqualTo(1);
    }
}
