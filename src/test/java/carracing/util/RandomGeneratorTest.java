package carracing.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("랜덤한 값을 생성하기 위한 랜덤 생성기를 위한 테스트")
class RandomGeneratorTest {
    private final RandomGenerator randomGenerator = new RandomGenerator();

    @DisplayName("0에서 9까지 랜덤한 양의 정수 값 생성 확인")
    @Test
    void generateZeroToNineTest() {
        // When
        int randomNumber = randomGenerator.generateZeroOrPositiveNumber(9);

        // Then
        assertThat(randomNumber).isBetween(0, 9);
    }
}
