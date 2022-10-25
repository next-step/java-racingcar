package racingCar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomMoveStrategyTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void 랜덤값_4이하일_때_이동가능(int random) {
        assertThat(new RandomMoveStrategy().canMove(random)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 6, 7, 8, 9})
    void 랜덤값_4초과일_때_이동불가(int random) {
        assertThat(new RandomMoveStrategy().canMove(random)).isEqualTo(false);
    }
}
