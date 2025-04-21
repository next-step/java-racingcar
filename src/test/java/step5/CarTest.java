package step5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.Car;

class CarTest {
    @Test
    @DisplayName("정지 테스트")
    void stop() {
        Car car = new Car("yeo", 2);
        car.move(2);
        Assertions.assertThat(car.getPosition()).isEqualTo(2);
    }
    @Test
    @DisplayName("전진 테스트")
    void move() {
        Car car = new Car("yeo", 2);
        car.move(4);
        Assertions.assertThat(car.getPosition()).isEqualTo(3);
    }

    @Test
    void 자동차_이름_초과() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car("dfafdasdfasdf"));
    }
}
