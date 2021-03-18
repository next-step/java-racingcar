package step3.study.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGeneratorTest {

    @Test
    @DisplayName("랜덤번호는 0~9까지 사이의 숫자로 생성된다.")
    void getRandomNumber() {
        RandomGenerator randomGenerator = new RandomGenerator(new Random());
        assertThat(randomGenerator.createNumber()).isBetween(0, 9);
    }
}
