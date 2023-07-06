package racing.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void goForwardTrueTest() {
        //given
        Car car = new Car("pobi");

        //when
        car.goForward();

        //then
        assertThat(car.getPosition()).isEqualTo(2);
    }

}
