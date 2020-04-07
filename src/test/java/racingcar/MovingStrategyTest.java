package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.MovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class MovingStrategyTest {

    @DisplayName("생성된 숫자가 4이상이면 움직일 수 있다 ")
    @ParameterizedTest
    @ValueSource(ints = {4, 8})
    void carMove(int randomNumber) {
        MovingStrategy movingStrategy = new MovingStrategy();
        assertThat(movingStrategy.movable(randomNumber)).isTrue();
    }

    @DisplayName("생성된 숫자가 4보다 작으면 움직일 수 없다 ")
    @ParameterizedTest
    @ValueSource(ints = {1, 3})
    void carNotMove(int randomNumber) {
        MovingStrategy movingStrategy = new MovingStrategy();
        assertThat(movingStrategy.movable(randomNumber)).isFalse();
    }
}
