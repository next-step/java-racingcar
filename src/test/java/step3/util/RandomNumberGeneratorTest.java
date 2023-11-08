package step3.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    @Test
    @DisplayName("자동차의 이동 여부를 결정하는 random 값은 0에서 9사이이다.")
    void carMoveException() {
        // given
        int randomInt = RandomNumberGenerator.makeRandomNumber();

        // then
        assertThat(randomInt).isLessThan(10);
        assertThat(randomInt).isGreaterThan(-1);
    }}
