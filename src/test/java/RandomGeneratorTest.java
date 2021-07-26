import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGeneratorTest {
    @DisplayName("연속해서 호출하면 다른값이 나와야한다.")
    @Test
    void random() {
        RandomGenerator randomUtil = new RandomGenerator();
        assertThat(randomUtil.getRandomInt() + randomUtil.getRandomInt())
                .isNotEqualTo(randomUtil.getRandomInt() + randomUtil.getRandomInt());
    }

    @DisplayName("랜덤 값이 0-9 사이의 값인지 확인")
    @Test
    void random_range() {
        RandomGenerator randomUtil = new RandomGenerator();
        assertThat(randomUtil.getRandomInt()).isBetween(0, 9);
    }
}
