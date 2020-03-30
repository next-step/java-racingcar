package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputOutputTest {

    @DisplayName("사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다")
    @Test
    void inputOutput() {
        RacingGame game = new RacingGame(5, 3);
        List<List<Integer>> result = game.run();

        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0).size()).isEqualTo(5);
    }
}
