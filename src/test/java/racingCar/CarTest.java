package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("Car 클래스 생성")
    void generateCarClass(){
        Car car = new Car();
        car.forward();
        assertThat(car.distance()).isEqualTo("-");
    }

}
