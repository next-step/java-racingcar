package game.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    final int BOUND = 10;
    final RandomNumberGenerator generator = new RandomNumberGenerator(BOUND);

    @RepeatedTest(10)
    @DisplayName("0 ~ BOUND 사이의 숫자가 출력되는지 확인")
    void check_if_in_bound(){
        int number = generator.getNumber();
        assertThat(number).isBetween(0, BOUND);
    }
}