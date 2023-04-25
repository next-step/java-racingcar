package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingTest {

    @Test
    @DisplayName("음의 정수가 입력되면 예외를 발생시킨다.")
    void inputNegativeException() {
        assertThatThrownBy(() -> Racing.validation(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0이 입력되면 예외를 발생시킨다.")
    void inputZeroException() {
        assertThatThrownBy(() -> Racing.validation(0))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("move count 이상으로 게임을 진행할 수 없다")
    void canNotRunOverMoveCount() {
        Racing racing = new Racing(1, 1);
        racing.run();
        racing.run();
        assertThat(racing.getCurrentMoveCount()).isEqualTo(1);
    }


}
