package study;

import com.step3.model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {
    @Test
    @DisplayName("Car class 생성자 test")
    void create() {
        Car car = new Car(0, 0);
        assertThat(car).isEqualTo(new Car(0, 0));
    }

    @Test
    @DisplayName("Car move 후 Car class로 return test")
    void move() {
        Car car = new Car(0, 0);
        assertThat(car.move(7)).isEqualTo(new Car(0,1));
    }

    @Test
    @DisplayName("Car 이동 거리 print test")
    void getResult() {
        Car car = new Car(0, 3);
        assertThat(car.getResult()).isEqualTo("---");
    }
}
