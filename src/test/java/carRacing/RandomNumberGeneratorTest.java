package carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("랜덤숫자 테스트")
public class RandomNumberGeneratorTest {

    @Test
    @DisplayName("랜덤 숫자가 0-9 사이로 생성되는지 확인.")
    void 랜덤생성_확인() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        int result = numberGenerator.generate();
        assertThat(result).isBetween(0, 9);
    }
}
