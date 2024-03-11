package racingCar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

public class MoveStrategyTest {

    private static final Random random = new Random();
    private MoveStrategy strategy;

    @BeforeEach
    void init(){
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

    private int createRandomDistance(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}
