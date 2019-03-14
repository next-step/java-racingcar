package racing.application;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void 한칸이동() {
        Car car = new Car("차");

        car.move();

        assertThat(car.getPosition()).isEqualTo(2);
    }
}