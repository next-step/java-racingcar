package racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest()
    @ValueSource(ints = {1, 2, 3, 4})
    void 값4이하로_run을_했을경우_1을_반환한다(int number) {
        Car car = new Car();
        int advance = car.run(number);
        assertThat(advance).isEqualTo(1);
    }

    @ParameterizedTest()
    @ValueSource(ints = {5, 6, 7})
    void 값5이상으로_run을_했을경우_0을_반환한다(int number) {
        Car car = new Car();
        int advance = car.run(number);
        assertThat(advance).isEqualTo(0);
    }

    @Test
    void 값1_4_5으로_run을_했을경우_2를_반환한다() {
        Car car = new Car();
        car.run(1);
        car.run(4);
        int advance = car.run(5);
        assertThat(advance).isEqualTo(2);
    }
}