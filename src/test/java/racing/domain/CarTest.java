package racing.domain;

import org.junit.jupiter.api.Test;
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

    @Test
    void samePositionTest() {
        //given
        Car car1 = new Car("pobi", 1);
        Car car2 = new Car("crong", 1);

        //when, then
        assertThat(car1.isSamePosition(car2)).isTrue();
    }

    @Test
    void differentPositionTest() {
        //given
        Car car1 = new Car("pobi", 1);
        Car car2 = new Car("crong", 2);

        //when, then
        assertThat(car1.isSamePosition(car2)).isFalse();
    }
}
