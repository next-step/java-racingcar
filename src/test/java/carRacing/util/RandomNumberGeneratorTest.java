package carRacing.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("랜덤 숫자를 생성하는 객체 관련 테스트")
public class RandomNumberGeneratorTest {
    @Test
    @DisplayName("생성된 랜덤 숫자가 0-9 사이값인지 확인")
    void 랜덤숫자_생성_경계값_확인() {
        RandomNumberGenerator randomNumberGeneration = new RandomNumberGenerator();
        int result = randomNumberGeneration.generate();
        assertThat(result).isBetween(0, 9);
    }
}
