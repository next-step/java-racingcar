package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    @Test
    @DisplayName("9이하의 정수형 난수가 생성되는지 테스트")
    void getRandomInt() {
        IntStream.range(0, 100)
                .forEach(x ->
                        assertThat(RandomNumberGenerator.getRandomNumberGenerator().getRandomInt()).isBetween(0, 9));
    }

    @Test
    @DisplayName("싱글톤 Test")
    void singletonTest() {
        assertThat(RandomNumberGenerator.getRandomNumberGenerator())
                .isEqualTo(RandomNumberGenerator.getRandomNumberGenerator());
    }
}
