package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar4.model.RandomNumber;

import static org.assertj.core.api.Assertions.assertThat;
public class RacingCar4RandomTest {

    @DisplayName("랜덤값이 0이상 9이하이다.")
    @Test
    void randomNumber() {
        int number = RandomNumber.getNumber();

        assertThat(number >= 1 && number <= 9).isTrue();
    }
}
