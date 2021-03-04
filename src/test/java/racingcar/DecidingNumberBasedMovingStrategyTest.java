package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.DecidingNumberBasedMovingStrategy;
import racingcar.domain.NumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class DecidingNumberBasedMovingStrategyTest {

    private NumberGenerator createFixedNumberGenerator(int number) {
        return new NumberGenerator() {
            @Override
            public int generate() {
                return number;
            }
        };
    }
    @ParameterizedTest
    @CsvSource(value = {"3:false", "2:false", "3:false","4:true","7:true"}, delimiter = ':')
    @DisplayName("생성된 값이 4이상의 값은 movable하고 4미만의 값은 movable하지 않다를 테스트")
    void isMovable(int number, boolean expected) {
        NumberGenerator fixedNumberGenerator = createFixedNumberGenerator(number);
        DecidingNumberBasedMovingStrategy movingStrategy = new DecidingNumberBasedMovingStrategy(fixedNumberGenerator);
        assertThat(movingStrategy.isMovable()).isEqualTo(expected);
    }
}
