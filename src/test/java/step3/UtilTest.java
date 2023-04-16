package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.util.NumberGenerator;

public class UtilTest {

    @Test
    @DisplayName("숫자가 0~9 사이에서 랜덤하게 생성되는지 확인")
    public void checkNumberGenerator() {
        int randomNumber = NumberGenerator.makeRandomly();
        Assertions.assertThat(randomNumber)
                .isGreaterThanOrEqualTo(1)
                .isLessThan(10);
    }
}

/*
    isGreaterThanOrEqualTo(expectedValue) : expectedValue보다 크거나 같은지 확인
    isLessThan(expectedValue) : expectedValue보다 작은지 확인
 */
