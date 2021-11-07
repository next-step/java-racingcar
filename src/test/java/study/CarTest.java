package study;

import com.step3.model.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {
    @Test
    void create() {
        Car car = new Car(0, 0);
        assertThat(car).isEqualTo(new Car(0, 0));
    }

    @Test
    void move() {
        Car car = new Car(0, 0);
        assertThat(car.move(7)).isEqualTo(new Car(0,1));
    }

    @Test
    void getResult() {
        Car car = new Car(0, 3);
        assertThat(car.getResult()).isEqualTo("---");
    }
}
