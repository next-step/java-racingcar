package ThirdStep;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    final private static int INIT_LOCATION = 0;

    private Car car;

    @BeforeEach
    void setCar() {
        car = new Car("robin");
    }

    @Test
    @DisplayName("Car를 최초 생성 시 location = 0이다.")
    void Car_초기화() {
        assertThat(car.getLocation()).isEqualTo(INIT_LOCATION);
    }

    @Test
    @DisplayName("최초 생성되어 location이 0인 Car의 move에 true가 전달되면 location은 1이 된다.")
    void Car_이동_true() {
        car.move(() -> true);

        assertThat(car.getLocation()).isEqualTo(1);
    }

    @Test
    @DisplayName("최초 생성되어 location이 0인 Car의 move에 false가 전달되면 그대로 0이다.")
    void Car_이동_false() {
        car.move(() -> true);

        assertThat(car.getLocation()).isEqualTo(1);
    }
}
