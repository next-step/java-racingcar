import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void 자동차_전진() {
        Car car = new Car(0);
        car.go();
        assertThat(car.getLocation()).isEqualTo(1);
    }

    @Test
    void 자동차_랜덤_전진() {
        Car car = new Car(0);
        if (car.randomGo())
            assertThat(car.getLocation()).isEqualTo(1);
        else
            assertThat(car.getLocation()).isEqualTo(0);
    }
}
