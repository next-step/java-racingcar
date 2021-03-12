package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

class RandomClassStudyTest {

    @DisplayName("Random 클래스의 nextInt() 메서드 학습 테스트")
    @RepeatedTest(value = 10, name = "현재 Loop : {0}")
    void nextInt_RandomValue_True() {
        // given
        Random random = new Random();

        // when
        int actual = random.nextInt(10);
        assertAll(
                () -> assertThat(actual).isIn(0, 1, 2, 3, 4, 5, 6, 7, 8, 9),
                () -> assertThat(actual).isNotIn(-1, 10),
                () -> assertThat(actual).isBetween(0, 9)
        );
    }

}