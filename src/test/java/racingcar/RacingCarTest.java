package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.MovingStrategy;
import racingcar.domain.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    private MovingStrategy createFixedMovingStrategy(boolean movable) {
        return new MovingStrategy() {
            @Override
            public boolean isMovable() {
                return movable;
            }
        };
    }
    @ParameterizedTest
    @CsvSource(value = {"true:1","true:1","false:0"}, delimiter = ':')
    @DisplayName("자동차 move 테스트")
    void move(boolean movable,int expectedTravelDistance ) {
        RacingCar test = new RacingCar(createFixedMovingStrategy(movable));
        test.move();
        assertThat(test.getTravelledDistance()).isEqualTo(expectedTravelDistance);
    }
}
