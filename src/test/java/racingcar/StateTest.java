package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.State;

import static org.assertj.core.api.Assertions.assertThat;

public class StateTest {


    State state;

    @BeforeEach
    void setup() {
        state = new State();
    }

    @Test
    @DisplayName("상태값 증가 테스트")
    void increase() {
        state.increase();
        assertThat(state.equals(new State(1))).isTrue();
    }

    @Test
    @DisplayName("int가 주어질 경우, 더 큰 값 반환 테스트")
    void maxInt(){
        int max = state.max(7);
        assertThat(max).isEqualTo(7);
    }


}
