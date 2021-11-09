package racing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.mock.MockRandom;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("3단계 - 자동차 경주 - Car 단위 테스트")
class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    @DisplayName("자동차 랜덤 행동 이동 기능")
    void moveRandom() {
        car = new Car(new MockRandom()); // 10번 nextInt 수행시 7번 go 될 수 있는 Mock

        for (int i = 0; i < 10; i++) {
            car.moveRandom();
        }

        assertThat(car.getMovingDistance())
                .isEqualTo(7);
    }

    @Test
    @DisplayName("자동차 전진 기능")
    void go() {
        car.go();
        car.go();
        car.go();

        assertThat(car.getMovingDistance())
                .isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 정지 기능")
    void stopCar() {
        // 아무것도 하지않으면 정지

        assertThat(car.getMovingDistance())
                .isEqualTo(0);
    }
}
