package racing_car.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("랜덤 숫자가 4이상이면 move, 3이하이면 stop")
    void move() {
        Car car = new Car();
        car.move(() -> true);
        car.move(() -> true);
        car.move(() -> false);
        car.move(() -> true);
        
        assertThat(car).isEqualTo(new Car(3));
    }
}
