package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    void goForwardTrueTest() {
        //given
        Car car = new Car("pobi");

        //when
        car.goForward(true);

        //then
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void goForwardFalseTest() {
        //given
        Car car = new Car("pobi");

        //when
        car.goForward(false);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
