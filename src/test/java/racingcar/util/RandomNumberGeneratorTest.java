package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {
    @DisplayName("랜덤값을 생성한다.")
    @Test
    public void 랜덤값을_생성한다() {
        assertThat(RandomNumberGenerator.generate()).isBetween(0,9);
    }
}
