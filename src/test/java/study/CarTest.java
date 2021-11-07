package study;

import com.Car;
import com.GameProcessor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {
    @Test
    void create() {
        Car car = new Car(0);
        assertThat(car).isEqualTo(new Car(0));
    }

    @Test
    void move() {
        Car car = new Car(0);
        assertThat(car.move(true)).isEqualTo(new Car(1));
    }

    @Test
    void getResult() {
        Car car = new Car(3);
        assertThat(car.getResult()).isEqualTo("---");
    }
}
