package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LuckyNumberGeneratorTest {
    @Test
    @DisplayName("9이하의 정수형 난수가 생성되는지 테스트")
    void getRandomInt() {
        IntStream.range(0, 100)
                .forEach((i) -> assertThat(LuckyNumberGenerator.getRandomInt()).isBetween(0, 9));
    }
}
