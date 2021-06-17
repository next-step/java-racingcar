package racingcargame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcargame.model.RandomNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {
    @DisplayName(value = "랜덤수는 1부터 10까지이다.")
    @Test
    void random_number_is_between_1_and_10() {
        RandomNumber randomNumber = new RandomNumber();
        int v = randomNumber.createRandomNumber();
        assertThat(v >= 1 && v <= 10).isTrue();
    }
}
