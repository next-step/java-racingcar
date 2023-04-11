package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @DisplayName("RandomNumberGenerator 로 생성되는 숫자 범위 테스트")
    @RepeatedTest(10)
    void generateNumber() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        assertThat(numberGenerator.generateNumber())
                .isBetween(0, 9);
    }
}
