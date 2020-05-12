package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class RacingGameTest {

    @Test
    @DisplayName("랜덤 숫자 생성 테스트")
    void createRandomNumberTest() {
        Random random = new Random();
        int count = 100;

        for (int i = 0; i < count; i++) {
            Assertions.assertThat(random.nextInt(10)).isBetween(0, 9);
        }
    }
}
