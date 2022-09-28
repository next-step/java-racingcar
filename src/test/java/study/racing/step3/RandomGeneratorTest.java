package study.racing.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorTest {

    @Test
    @DisplayName("generate메서드는 0과 9사이의 숫자를 반환한다.")
    void isGenerate_ShouldReturnFromZeroToNine() {
        //when
        int number = RandomGenerator.generate();

        //then
        assertThat(number).isBetween(0, 9);
    }
}
