package racing.vehicle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.testutil.DeterministicHighRandom;
import racing.testutil.DeterministicLowRandom;

import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RandomEngineTest {
    static Stream<Arguments> deterministicRandomAndResult() {
        return Stream.of(
                Arguments.arguments(new DeterministicHighRandom(), 1),
                Arguments.arguments(new DeterministicLowRandom(), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("deterministicRandomAndResult")
    public void accelerate(Random randomEngine, int result) {
        RandomEngine engine = new RandomEngine(randomEngine);
        assertThat(engine.accelerate()).isEqualTo(result);
    }
}
