package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Car 테스트")
class CarTest {

    private String carName = "1번 자동차";
    private Car car = new Car(carName);

    @DisplayName("move시 position값 변경")
    @Test
    void move() {
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차 이름 확인")
    @Test
    void getName() {
        assertThat(car.getName()).isEqualTo(carName);
    }

    @DisplayName("현재 포지션 확인")
    @Test
    void getPosition() {
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
