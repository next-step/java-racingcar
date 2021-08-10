package racingcargame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcargame.model.RandomNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    @DisplayName(value = "랜덤수는 1부터 10까지이다.")
    @Test
    void random_number_is_between_0_and_9() {
        assertThat(RandomNumber.createRandomNumber()).isBetween(0, 9);
    }
}
