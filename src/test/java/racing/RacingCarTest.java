package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {
    private RacingCar racingCar;

    private static final int MOVE_POSITION = 1;
    private static final int STOP_POSITION = 0;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 9})
    void 전진유무판단숫자가_4이상이면_전진한다(int conditionNumber) {
        racingCar.attemptToMove(conditionNumber);
        assertThat(racingCar.getPosition()).isEqualTo(MOVE_POSITION);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 3})
    void 전진유무판단숫자가_4미만이면_전진하지_않는다(int conditionNumber) {
        racingCar.attemptToMove(conditionNumber);
        assertThat(racingCar.getPosition()).isEqualTo(STOP_POSITION);
    }
}
