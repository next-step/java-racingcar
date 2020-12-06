package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("랜덤한 값을 생성하기 위한 랜덤 생성기를 위한 테스트")
class RandomGeneratorTest {

    private static final int ZERO = 0;
    private static final int NINE = 9;
    private final RandomGenerator randomGenerator = new RandomGenerator();

    @DisplayName("0에서 9까지 랜덤한 양의 정수 값 생성 확인")
    @Test
    void generateZeroToNineTest() {
        // When
        int randomNumber = randomGenerator.generateZeroToNineInt();

        // Then
        assertThat(randomNumber).isBetween(ZERO, NINE);
    }
}
