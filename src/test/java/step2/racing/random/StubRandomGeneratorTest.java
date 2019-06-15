package step2.racing.random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class StubRandomGeneratorTest {

    private int fixedNumber = 5;
    private StubRandomGenerator stubRandomGenerator = new StubRandomGenerator(fixedNumber);

    @Test
    @DisplayName("고정된 숫자가 리턴되는 StubRandomGenerator 검증")
    void getRandomIntValue() {

        IntStream.range(0, 100)
                .forEach(i -> assertThat(stubRandomGenerator.getRandomIntValue()).isEqualTo(fixedNumber));
    }
}