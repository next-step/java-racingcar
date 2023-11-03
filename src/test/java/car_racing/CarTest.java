package car_racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("생성/현재위치와 남은이동횟수로 생성/생성된다.")
    void createCar() {
        Car car = new Car(0, 10);
        assertThat(car).isInstanceOf(Car.class);
    }
}
