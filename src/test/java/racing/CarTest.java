package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    @DisplayName("자동차 이름과 위치를 입력 받아서 객체 생성")
    public void CarTest() {
        Car car = new Car("test", 1);
        assertThat(car.getName()).isEqualTo("test");
        assertThat(car.getCurrentLocation()).isEqualTo(1);
    }

    @Test
    @DisplayName("movePoint가 4 이상일 때만 이동")
    public void CarMoveTest() {
        Car car = new Car("test", 1);
        car.move(4);

        assertThat(car.getCurrentLocation()).isEqualTo(2);

        car.move(2);
        assertThat(car.getCurrentLocation()).isEqualTo(2);
    }
}
