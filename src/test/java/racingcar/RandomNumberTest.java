package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utility.RandomNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    @Test
    @DisplayName("0~9사이 정수랜덤생성기")
    public void checkRandomNumber_ReturnPositiveNumberUnderNine() {
        RandomNumber randomNumber = new RandomNumber();
        int result = randomNumber.calculateRandomNumber();

        assertThat(result)
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }
}