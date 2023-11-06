package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.RandomNumber;

import static org.assertj.core.api.Assertions.*;

public class RandomNumberTest {
    @Test
    @DisplayName("랜덤값이 0~9 값으로 생성되는지 확인한다.")
    public void RandomNumber() {
        int randomNumber = RandomNumber.getRandomNumber();
        assertThat(randomNumber).isGreaterThanOrEqualTo(0);
        assertThat(randomNumber).isLessThan(10);
    }
}