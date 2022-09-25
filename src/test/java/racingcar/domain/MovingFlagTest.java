package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MovingFlagTest {
    @DisplayName("이동값이 4보다 크거나 같으면 true 를 리턴하고 아니면 false 를 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = { "0=false", "1=false", "2=false", "3=false", "4=true", "5=true", "10=true" }, delimiter = '=')
    void canMove(int movingValue, boolean expected) {
        assertThat(new MovingFlag(movingValue).canMove()).isEqualTo(expected);
    }
}
