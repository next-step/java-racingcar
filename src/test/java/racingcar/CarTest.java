package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("Car를 만드는 지에 대한 Test")
    void makeCarTest() {
        Car car = new Car();
        assertThat(car).isInstanceOf(Car.class);
    }


}
