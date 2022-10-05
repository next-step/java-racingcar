package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    Car car;

    @BeforeEach
    void generateCar() {
        car = new Car();
    }

    @Test
    @DisplayName("자동차의 최초 거리는 0이다")
    void checkFirstDistance() {
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차가 1회 움직이면 거리는 1이다")
    void checkMoveResult() {
        car.move();
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("게임을 1회 시도했을 때 자동차의 거리는 1보다 작거나 같다")
    void test() {
        car.tryOneRound();
        assertThat(car.getDistance() <= 1).isEqualTo(true);
    }
}
