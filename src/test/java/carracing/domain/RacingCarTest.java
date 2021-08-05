package carracing.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingCarTest {

    @ParameterizedTest(name = "이동전략에 따라 자동차가 이동한다.")
    @ValueSource(strings = {"false", "true"})
    public void moveTest(boolean movable) {
        Position positionBeforeMove = Position.of(0);
        CarName carName = CarName.of("yunb");
        RacingCar racingCar = RacingCar.of(positionBeforeMove, carName);
        racingCar.move(() -> movable);
        assertThat(racingCar.getPosition())
                .isEqualTo(movable ? positionBeforeMove.next() : positionBeforeMove);
    }

}