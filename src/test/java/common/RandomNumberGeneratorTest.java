package common;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("0 ~ 9 사이의 랜덤 숫자를 반환한다.")
    void getRandomNumber() {
        //given
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        //when && then
        assertThat(numberGenerator.getNumber()).isBetween(0, 9);
    }
}