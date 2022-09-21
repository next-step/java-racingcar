package ThirdStep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    final private static int INIT_LOCATION = 0;

    @Test
    @DisplayName("Car를 최초 생성 시 location = 0이다.")
    void Car_초기화() {
        Car car = new Car();

        assertThat(car.getLocation()).isEqualTo(INIT_LOCATION);
    }

    @Test
    @DisplayName("Car의 move 메소드는 location을 1 증가시킨다.")
    void Car_이동() {
        Car car = new Car();

        car.move();

        assertThat(car.getLocation()).isEqualTo(INIT_LOCATION + 1);
    }
}
