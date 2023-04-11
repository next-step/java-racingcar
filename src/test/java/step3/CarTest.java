package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("Car 의 default position 테스트")
    @Test
    void carPositionWhenNotCallMove() {
        Car car = new Car(new Engine(() -> 0));
        assertThat(car.getPosition())
                .isEqualTo(0);
    }

    @DisplayName("Engine 이 항상 OK 일 때, move() 동작 테스트")
    @Test
    void carPositionWhenEngineIsAlwaysOk() {
        Car car = new Car(new Engine(() -> 5));
        for (int i = 0; i < 3; i++) {
            car.move();
        }
        assertThat(car.getPosition())
                .isEqualTo(3);
    }

    @DisplayName("Engine 이 항상 Not OK 일 때, move() 동작 테스트")
    @Test
    void carPositionWhenEngineIsNeveOk() {
        Car car = new Car(new Engine(() -> 0));
        for (int i = 0; i < 3; i++) {
            car.move();
        }
        assertThat(car.getPosition())
                .isEqualTo(0);
    }
}
