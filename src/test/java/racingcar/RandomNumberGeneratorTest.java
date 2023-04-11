package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("랜덤 숫자 생성 테스트")
public class RandomNumberGeneratorTest {

    @DisplayName("0 부터 9까지의 랜덤 숫자를 반환한다")
    @Test
    void generateRandomNumberTest() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int result = randomNumberGenerator.generate();
        Assertions.assertThat(result).isBetween(0, 9);
    }
}
