package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumberGeneratorTest {
    @Test
    @DisplayName("정수를 전달시 해당 정수 값을 반환한다.")
    public void basic_number(){
        NumberGenerator numberGenerator = new BasicNumberGenerator(5);
        assertThat(numberGenerator.get()).isEqualTo(5);
    }

    @Test
    @DisplayName("최대값을 전달시 최대값 미만의 정수들만 반환한다.")
    public void random_number(){
        NumberGenerator numberGenerator = new RandomNumberGenerator(5);
        assertThat(numberGenerator.get()).isLessThan(5);
    }
}