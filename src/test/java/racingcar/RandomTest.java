package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomTest {

    @DisplayName("java.util.Random 클래스 학습 테스트")
    @Test
    void random() {
        //given
        int randomNumber = new Random().nextInt(10);

        //when
        //then
        assertThat(randomNumber).isBetween(0, 9);
    }
}
