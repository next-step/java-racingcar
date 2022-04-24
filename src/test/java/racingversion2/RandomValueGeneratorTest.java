package racingversion2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingversion2.car.util.RandomValueGenerator;

class RandomValueGeneratorTest {

    @Test
    @DisplayName("0 이상 9 이하의 랜덤 숫자를 만들어 준다.")
    void randomValueGenerator() {
        for (int i = 0; i < 100; i++) {
            assertThat(RandomValueGenerator.generateRandomValue()).isBetween(0, 9);
        }
    }
}