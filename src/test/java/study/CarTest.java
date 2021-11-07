package study;

import com.Car;
import com.GameProcessor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {
    @Test
    void move() {
        Car car = new Car(0);
        assertThat(car.move(true)).isEqualTo(1);
    }
}
