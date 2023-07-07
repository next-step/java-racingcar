package racing.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 10})
    void notMoveTest(int number) {
        //given
        Car car = new Car("pobi");

        //when
        car = car.goForward(number);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void movableTest(int number) {
        //given
        Car car = new Car("pobi");

        //when
        car = car.goForward(number);

        //then
        assertThat(car.getPosition()).isEqualTo(2);
    }

}
