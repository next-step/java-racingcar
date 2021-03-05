package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.DecidingNumberBasedMovingStrategy;
import racingcar.domain.NumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class DecidingNumberBasedMovingStrategyTest {

    @ParameterizedTest
    @CsvSource(value = {"3:false", "2:false", "3:false","4:true","7:true"}, delimiter = ':')
    @DisplayName("생성된 값이 4이상의 값은 movable하고 4미만의 값은 movable하지않는다 테스트")
    void isMovable(int number, boolean expected) {
        NumberGenerator fixedNumberGenerator = () -> number;
        DecidingNumberBasedMovingStrategy movingStrategy = new DecidingNumberBasedMovingStrategy(fixedNumberGenerator);
        assertThat(movingStrategy.isMovable()).isEqualTo(expected);
    }
}
