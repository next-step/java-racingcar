package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("Car 객체가 생성이 잘 되었는가?")
    @Test
    void create_car_test() {
        Car car = new Car();
        assertThat(car).isNotNull();
    }

    @DisplayName("Car 위치정보를 설정하고 가져올 수 있나?")
    @Test
    void car_set_get_location_test() {
        Car car = new Car();
        car.setLocation("-");
        assertThat("-").isEqualTo(car.getLocation());
    }

}
