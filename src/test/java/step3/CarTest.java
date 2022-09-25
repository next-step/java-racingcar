package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    Car car = new Car();

    @Test
    @DisplayName("4이상이면 전진")
    public void moveTest1() {
        car.move(4);
        assertThat(car.pos).isEqualTo(1);
    }
}
