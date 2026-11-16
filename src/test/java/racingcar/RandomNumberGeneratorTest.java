package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    @DisplayName("10을 주면 0부터 9 사이의 값을 항상 반환한다.")
    @Test
    public void test_1() {
        assertThat(new RandomNumberGenerator(10).create()).isBetween(0, 9);
    }
}