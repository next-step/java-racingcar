package study.racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomTest {

    @DisplayName("랜덤 기능 테스트")
    @Test
    void 정해진_범위_내의_랜덤숫자가_나온다() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int randomValue = random.nextInt(10);
            Assertions.assertThat(randomValue).isBetween(0, 10);
        }
    }

}
