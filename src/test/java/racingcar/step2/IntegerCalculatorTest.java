package racingcar.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class IntegerCalculatorTest {

    IntegerCalculator integerCalculator;

    @BeforeEach
    void setUp() {
        integerCalculator = new IntegerCalculator();
    }

    @DisplayName("List<Integer> 타입의 리스트를 받으면, 그 내부 값들의 합을 구한다.")
    @Test
    void sumListOfInteger() {
        // given
        List<Integer> tokens = List.of(1, 2, 3);

        // when
        int sum = integerCalculator.sum(tokens);

        // then
        assertThat(sum).isEqualTo(6);
    }
}