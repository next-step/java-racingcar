package step2.racing.random;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class RealRandomGeneratorTest {

    private final int bound = 10;
    private RealRandomGenerator realRandomGenerator = new RealRandomGenerator(bound);

    @Test
    void getRandomIntValue() {

        IntStream.range(0, 1000)
                .forEach(i -> assertThat(realRandomGenerator.getRandomIntValue())
                        .isGreaterThanOrEqualTo(0)
                        .isLessThan(bound));
    }
}