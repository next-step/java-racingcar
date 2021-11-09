package util;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomGeneratorTest {
    private final int TRY_NUMBER = 1_000;
    private final int LOWER_BOUND = 0;
    private final int UPPER_BOUND = 9;

    @Test
    void RandomGeneratorTest() {
        IntStream.range(0, TRY_NUMBER).forEach( number ->
                assertThat(RandomGenerator.generateNumberBetweenZeroToNine()).isBetween(LOWER_BOUND, UPPER_BOUND));
    }
}
