package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void move() {
        final Car car = new Car();
        car.play(new Condition());
        assertThat(car.location).isEqualTo(1);
    }
}
