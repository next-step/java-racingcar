package racingGame;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("항상 이동 정책이면 위치 +1 된 새 Car를 반환한다")
    void move_alwaysMove_returnsNewCarWithIncrementedPosition() {
        Car origin = new Car("car_0", 0);
        Car moved = origin.move(new TestPositions.AlwaysMove());

        // 불변 확인: 원본은 그대로, 새 객체는 +1
        assertThat(origin.getPosition()).isEqualTo(0);
        assertThat(moved.getPosition()).isEqualTo(1);
        assertThat(moved.getName()).isEqualTo("car_0");
        assertThat(moved).isNotSameAs(origin);
    }

    @Test
    @DisplayName("절대 이동 안 함 정책이면 위치 그대로인 새 Car를 반환한다")
    void move_neverMove_returnsNewCarWithSamePosition() {
        Car origin = new Car("car_0", 3);
        Car stayed = origin.move(new TestPositions.NeverMove());

        assertThat(origin.getPosition()).isEqualTo(3);
        assertThat(stayed.getPosition()).isEqualTo(3);
        assertThat(stayed).isNotSameAs(origin);
    }
}
