import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    @DisplayName("현재 위치는 전진한 횟수와 같다.")
    void moveForwardTest() {
        car.moveForward();
        car.moveForward();

        assertThat(car.currentLocation).isEqualTo(2);
    }

    @Test
    @DisplayName("첫 번째 게임에서는 무조건 1칸 전진한다.")
    void makeFirstMoveTest() {
        assertThat(car.currentLocation).isEqualTo(0); // 게임 플레이 전
        car.play(); // 첫번째 게임 플레이
        assertThat(car.currentLocation).isEqualTo(1);
    }

    @Test
    @DisplayName("두 번째 이후 게임에서는 1칸 혹은 0칸 전진한다.")
    void makeSecondMoveTest() {
        car.play(); // 첫 번째 게임 플레이
        car.play(); // 두 번째 게임 플레이
        assertThat(car.currentLocation).isBetween(1, 2);
    }
}