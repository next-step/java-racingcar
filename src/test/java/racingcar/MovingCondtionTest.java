package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MovingCondtionTest {

    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:false", "2:false", "3:false", "4:true", "5:true"}, delimiter = ':')
    @DisplayName("차가 전진하는 조건은 값이 4이상일 경우")
    void moveConditionsTest(int value, boolean expected) {
        assertThat(MovingCondtion.isMove(value)).isEqualTo(expected);
    }
}
