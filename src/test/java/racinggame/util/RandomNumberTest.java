package racinggame.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RandomNumberTest {

    @DisplayName("0부터 9 사이의 랜덤한 숫자를 만든다.")
    @Test
    void zero_to_nine_number() {
        RandomNumber number = new RandomNumber();
        for (int i = 0; i < 100; i++) {
            assertThat(number.createBetweenZeroToNine()).isBetween(0, 9);
        }
    }
}
