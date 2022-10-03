package racing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomCarMovingStrategyTest {

    @ParameterizedTest(name = "test_not_move {0}")
    @ValueSource(ints = {0, 1, 2, 3})
    void test_not_move(int randomNumber) {
        CarMovingStrategy strategy = new RandomCarMovingStrategy(getStaticRandomGenerator(randomNumber));
        assertThat(strategy.shouldMove()).isFalse();
    }

    @ParameterizedTest(name = "test_move {0}")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void test_move(int randomNumber) {
        CarMovingStrategy strategy = new RandomCarMovingStrategy(getStaticRandomGenerator(randomNumber));
        assertThat(strategy.shouldMove()).isTrue();
    }

    private Random getStaticRandomGenerator(int number) {
        return new Random() {
            @Override
            public int nextInt(int bound) {
                return number;
            }
        };
    }
}
