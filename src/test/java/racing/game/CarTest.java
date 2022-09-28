package racing.game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.game.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = { 5, 6, 7, 8 })
    void 자동차는_조건에_맞으면_움직일_수_있다(int bound) {
        Car car = new Car("name", limit -> bound);
        moveToPositionTwo(car);
        assertThat(car.currentPosition()).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void 자동차는_조건에_안맞으면_움직이지_않는다(int bound) {
        Car car = new Car("name", limit -> bound);

        moveToPositionTwo(car);
        assertThat(car.currentPosition()).isEqualTo(1);
    }

    @Test
    void 자동차는_출발선에_있지_않으면_무조건_움직인다() {
        Car car = new Car("name", limit -> 0);
        car.move();
        assertThat(car.currentPosition()).isEqualTo(1);
    }

    private void moveToPositionTwo(Car car) {
        car.move();
        car.move();
    }
}
