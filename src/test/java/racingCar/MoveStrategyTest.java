package racingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoveStrategyTest {

    private static final Random random = new Random();
    private MoveStrategy strategy;

    @BeforeEach
    void init() {
        strategy = new MoveStrategy();
    }

    @RepeatedTest(value = 10)
    void Random값이_4이상이면_true를_반환한다() {
        assertThat(strategy.isMovable(createRandomDistance(4, 10))).isEqualTo(true);
    }

    @RepeatedTest(value = 10)
    void Random값이_4미만이면_false를_반환한다() {
        assertThat(strategy.isMovable(createRandomDistance(0, 3))).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3, 10, 11, 12})
    void 입력값이_0미만10이상일때_Error(int input){
        assertThatThrownBy(() -> strategy.isMovable(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    private int createRandomDistance(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}
