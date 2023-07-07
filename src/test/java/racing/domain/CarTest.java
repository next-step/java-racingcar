package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void goForwardTrueTest() {
        //given
        Car car = new Car("pobi");

        //when
        car = car.goForward(true);

        //then
        assertThat(car.getPosition().getPosition()).isEqualTo(2);
    }

    @Test
    void goForwardFalseTest() {
        //given
        Car car = new Car("pobi");

        //when
        car = car.goForward(false);

        //then
        assertThat(car.getPosition().getPosition()).isEqualTo(1);
    }
}
