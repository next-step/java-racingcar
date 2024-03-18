package step3.application.domain.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PositionTest {

    @ParameterizedTest
    @CsvSource(value = {"4:true:5", "1:false:1"}, delimiter = ':')
    void test(int number, boolean canMove, int answer) {
        Position position = new Position(number);
        Assertions.assertThat(position.add(canMove)).isEqualTo(answer);
    }
}