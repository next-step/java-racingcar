package racinggame.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.car.Car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car(CarName.of("자동차"));
    }

    @DisplayName("자동차 객체가 전진 조건을 만족하면 position 값을 증가 시킨다.")
    @Test
    void car_move() {
        car.race(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차 객체가 전진 조건을 만족하지 않으면 position 값을 증가 시키지 않는다.")
    @Test
    void car_stop() {
        car.race(() -> false);
        assertThat(car.getPosition()).isZero();
    }

    @DisplayName("하나의 자동차 객체가 여러번 시도했을 때의 position 값 테스트 ")
    @Test
    void position_count() {
        car.race(() -> true);
        car.race(() -> false);
        car.race(() -> true);

        assertThat(car.getPosition()).isEqualTo(2);
    }
}
