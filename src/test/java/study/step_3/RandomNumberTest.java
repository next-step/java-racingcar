package study.step_3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberTest {

    @Test
    @DisplayName("0에서 9 사이의 랜덤 값을 생성한다")
    void shouldGenerateRandomNumberBetweenZeroAndNine() {
        RandomNumber randomNumber = new RandomNumber();

        assertThat(randomNumber.generate()).isBetween(0, 9);
    }
}