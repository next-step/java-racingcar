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

    @Test
    @DisplayName(value = "RandomStrategy move가 랜덤값을 뱉는지 테스트")
    public void isRandomStrategy_ShouldReturnRandomValue() {
        RandomStrategy randomStrategy = new RandomStrategy();
        randomStrategy.move();

        assertThat(randomStrategy.move()).isBetween(0,10);

    }
}
