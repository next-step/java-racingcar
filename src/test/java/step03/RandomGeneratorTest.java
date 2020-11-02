package step03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorTest {

    @DisplayName("0 부터 양의정수 입력값 이하의 랜덤 정수값을 반환하는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 9, 100})
    public void ZeroToPositiveIntGenerate_MaxPositiveInteger_isBetweenZeroToMaxPositiveInteger(int input) {
        final int result = RandomGenerator.ZeroToPositiveIntGenerate(input);
        assertThat(result).isBetween(0, input + 1);
    }
}
