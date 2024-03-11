package game.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    final RandomNumberGenerator generator = new RandomNumberGenerator();
    final int BOUND = 10;

    @RepeatedTest(10)
    @DisplayName("0 ~ BOUND 사이의 숫자가 출력되는지 확인")
    void check_if_in_bound(){
        int number = generator.getNumbers(BOUND);
        assertThat(number).isBetween(0, BOUND);
    }
}