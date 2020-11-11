package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.Racing;
import step3.domain.strategy.Movable;
import step3.domain.strategy.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created By mand2 on 2020-11-11.
 */
class RacingTest {

    Racing racing;
    MoveStrategy moveStrategy;

    @BeforeEach
    void setUp() {
        moveStrategy = new Movable(new Randomize());
    }

    @Test
    @DisplayName("경기의 수가 0일 때 IllegalArgumentException 예외를 던진다")
    public void input_racing_round_number_is_zero() {
        assertThatThrownBy(() -> Racing.of("a,b,c", 0, moveStrategy))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("경기의 수가 음수일 때 IllegalArgumentException 예외를 던진다")
    @ValueSource(ints = {-19, -2, -514})
    public void input_racing_round_number_under_zero(int input) {
        assertThatThrownBy(() -> Racing.of("a,b", input, moveStrategy))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("경기의 수가 1이상일 때 라운드 세팅을 정상적으로 마친다")
    @ValueSource(ints = {1, 3, 40, 320})
    public void input_racing_round_number_over_one(int input) {
        racing = Racing.of("a,b,c", input, moveStrategy);
        assertEquals(input, racing.getRounds());
    }

}
