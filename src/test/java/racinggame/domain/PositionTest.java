package racinggame.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2,-1","2,1,1","2,2,0"})
    void 비교_테스트(int number1, int number2, int expected) {
        assertThat(new Position(number1).compareTo(new Position(number2))).isEqualTo(expected);
    }
}
