package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static step3.RandomNumberGenerator.randomNumber;

public class RandomNumberGeneratorTest {

    @DisplayName("0에서 9 사이에서 random 값을 구하기")
    @Test
    void test1() {
        assertThat(randomNumber()).isGreaterThanOrEqualTo(0);
        assertThat(randomNumber()).isLessThanOrEqualTo(9);
    }

}
