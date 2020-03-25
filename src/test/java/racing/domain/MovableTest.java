package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MovableTest {

    @ParameterizedTest
    @CsvSource(value = {"1:false", "4:true", "7:true"}, delimiter = ':')
    @DisplayName("조건에 따라 자동차가 움직일 지 여부를 제대로 return 하는지 확인 - 4 미만일 경우만 이동")
    void canDecisionMovable(int input, boolean expected) {
        Assertions.assertThat(Movable.isMovable(input)).isEqualTo(expected);
    }

}
