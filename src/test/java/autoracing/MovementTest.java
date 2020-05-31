package autoracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MovementTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, -20, 78989})
    public void createMovement(int distance) {
        assertThat(Movement.from(distance).getDistance()).isEqualTo(distance);
    }

    @DisplayName("자주 쓰이는 0과 1 Movement들을 정상적으로 캐싱되는가?")
    @Test
    public void cache() {
        assertThat(Movement.from(0)).isEqualTo(Movement.STATIONARY);
        assertThat(Movement.from(1)).isEqualTo(Movement.ONE_FORWARD);
    }

    @DisplayName("멈춤(STATIONARY)과 1칸 전진(ONE_FORWARD) Movement는 실제 0과 1값을 가지고 있는가?")
    @Test
    public void isCachedMovementContainedCorrectValue() {
        assertThat(Movement.STATIONARY.getDistance()).isEqualTo(0);
        assertThat(Movement.ONE_FORWARD.getDistance()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {-20, 35, 78989})
    public void equality(int distance) {
        Movement m1 = Movement.from(distance);
        Movement m2 = Movement.from(distance);
        assertThat(m1).isEqualTo(m2);
    }


}
