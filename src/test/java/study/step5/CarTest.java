package study.step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step5.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {
    @Test
    @DisplayName("자동차 객체 생성 실패")
    void failCreateCar() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Car car = new Car("test12");
        });
    }

    @Test
    @DisplayName("전진")
    void successGoTest() {
        Car car = new Car("pobi");
        car.go(4);
        assertThat(car.getScore()).isEqualTo(1);
    }

    @Test
    @DisplayName("정지")
    void failGoTest() {
        Car car = new Car("pobi");
        car.go(3);
        assertThat(car.getScore()).isEqualTo(0);
    }
}
