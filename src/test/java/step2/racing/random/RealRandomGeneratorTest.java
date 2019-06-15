package step2.racing.random;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class RealRandomGeneratorTest {

    private RealRandomGenerator realRandomGenerator = new RealRandomGenerator();

    @Test
    void getRandomIntValue() {

        int bound = 5;

        IntStream.range(0, 1000)
                .forEach(i -> assertThat(realRandomGenerator.getRandomIntValue(bound)).isGreaterThanOrEqualTo(0).isLessThan(bound));
    }
}