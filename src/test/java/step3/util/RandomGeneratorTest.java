package step3.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomGeneratorTest {

    @Test
    @DisplayName("랜덤 값이 0에서 9 사이의 값을 생성한다.")
    void makeRandomInt() {
        int randomInt = RandomGenerator.makeRandomInt();

        Assertions.assertThat(randomInt).isBetween(0, 9);
    }
}
