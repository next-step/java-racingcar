package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.RandomManaager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomTest {
    @Test
    @DisplayName("0~9 사이의 랜덤값을 구하는 테스트")
    public void testRandom() {
        int randomValue = RandomManaager.getInstance().getRandomValue();
        assertThat(randomValue < 10).isTrue();
    }

}
