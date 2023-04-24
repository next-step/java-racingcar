package step3;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingTest {

    @Test
    @DisplayName("음의 정수가 입력되면 예외를 발생시킨다.")
    void inputCarCountAndMoveCountException() {
        assertThatThrownBy(() -> Racing.validation(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }




}
