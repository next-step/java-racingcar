package racing.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RandomNumberTest {

    @DisplayName("0부터 9 사이의 랜덤 숫자를 만든다")
    @Test
    void createNumber() {
        //given
        RandomNumber number = new RandomNumber();

        //when, then
        assertThat(number.create()).isBetween(0, 9);
    }

}