package carracing.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMoveStrategyTest {

    @ParameterizedTest(name = "숫자가 3보다 큰 경우 movable true")
    @ValueSource(ints = {1, 3, 4, 9})
    public void randomNumberMovableTest(int mockRandomNumber) {
        Random alwaysReturnMockRandomNumber = createMockRandom(mockRandomNumber);
        MoveStrategy moveStrategy = RandomMoveStrategy.of(alwaysReturnMockRandomNumber);
        assertThat(moveStrategy.movable()).isEqualTo(mockRandomNumber > 3);
    }

    private Random createMockRandom(int mockRandomNumber) {
        return new Random() {
            @Override
            public int nextInt(int bound) {
                return mockRandomNumber;
            }
        };
    }

}