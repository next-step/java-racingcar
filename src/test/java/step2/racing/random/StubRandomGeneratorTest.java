package step2.racing.random;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StubRandomGeneratorTest {

    private int fixedNumber = 5;
    private StubRandomGenerator stubRandomGenerator = new StubRandomGenerator(fixedNumber);

    @Test
    void getRandomIntValue() {

        int bound = 10;

        IntStream.range(0, 1000)
                .forEach(i -> assertThat(stubRandomGenerator.getRandomIntValue(bound)).isEqualTo(5));
    }

    @Test
    void getRandomIntValue_bound() {

        int bound = 3;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> stubRandomGenerator.getRandomIntValue(bound))
                .withMessage("bound 값은 fixedNumber 보다 커야 합니다");
    }
}