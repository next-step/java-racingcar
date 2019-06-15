package step2.racing.random;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class StubRandomGeneratorTest {

    private int fixedNumber = 5;
    private StubRandomGenerator stubRandomGenerator = new StubRandomGenerator(fixedNumber);

    @Test
    void getRandomIntValue() {

        IntStream.range(0, 1000)
                .forEach(i -> assertThat(stubRandomGenerator.getRandomIntValue()).isEqualTo(fixedNumber));
    }
}