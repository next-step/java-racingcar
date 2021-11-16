package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.State;

import static org.assertj.core.api.Assertions.assertThat;

public class StateTest {

    @Test
    @DisplayName("상태값 증가 테스트")
    void increase() {
        State state = new State();
        state.increase();
        assertThat(state.equals(new State(1))).isTrue();
    }

    @Test
    @DisplayName("더 큰 값 반환 테스트")
    void maxInt() {
        State state = new State();
        State other = new State(7);
        State max = state.max(other);
        assertThat(max.equals(other)).isTrue();
    }

}
