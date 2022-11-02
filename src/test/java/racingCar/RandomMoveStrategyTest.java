package racingCar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingCar.domain.RandomMoveStrategy;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomMoveStrategyTest {

    public class RandomForTest extends Random {
        private final int fixedNumberForNextInt;

        public RandomForTest(int fixedNumberForNextInt) {
            this.fixedNumberForNextInt = fixedNumberForNextInt;
        }

        @Override
        public int nextInt(int bound) {
            return fixedNumberForNextInt;
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void 랜덤값_4이하일_때_이동가능(int fixedRandom) {
        assertThat(new RandomMoveStrategy(new RandomForTest(fixedRandom)).canMove()).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 6, 7, 8, 9})
    void 랜덤값_4초과일_때_이동불가(int fixedRandom) {
        assertThat(new RandomMoveStrategy(new RandomForTest(fixedRandom)).canMove()).isEqualTo(false);
    }
}
