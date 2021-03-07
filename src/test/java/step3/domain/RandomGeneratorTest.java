package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 랜덤 숫자 생성 테스트
 */
class RandomGeneratorTest {

    @DisplayName("랜덤 숫자 생성기 테스트")
    @ParameterizedTest(name = "bound: {0} 설정 시 범위 내에 생성되었는지 확인")
    @ValueSource(ints = {10, 5, 3})
    void generateRandomNumber_OneToBound(int bound) {
        RandomGenerator randomGenerator = new RandomGenerator(bound);
        assertThat(randomGenerator.generateOneToTen()).isLessThanOrEqualTo(bound);
    }
}
