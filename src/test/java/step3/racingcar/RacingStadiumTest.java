package step3.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

class RacingStadiumTest {

    @Test
    @DisplayName(value = "Random.nextInt(int s) 함수의 기능 테스트.")
    public void RandomUtilTest() {
        Random random = new Random();

        for (int i=0; i<100; i++) {
            int result = random.nextInt(10);
            assertThat(result).isBetween(0, 10);
        }
    }

}