package step2.racing.random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class RealRandomGeneratorTest {

    private final int bound = 10;
    private RealRandomGenerator realRandomGenerator = new RealRandomGenerator(bound);

    @Test
    @DisplayName("랜덤 값이 0 이상이고 bound 이하인지 검증")
    void getRandomIntValue() {

        IntStream.range(0, 1000)
                .forEach(i -> assertThat(realRandomGenerator.getRandomIntValue())
                        .isGreaterThanOrEqualTo(0)
                        .isLessThan(bound));
    }
}