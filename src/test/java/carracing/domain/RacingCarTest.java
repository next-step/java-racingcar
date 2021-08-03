package carracing.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingCarTest {

    @ParameterizedTest(name = "랜덤 값이 4이상인 경우 전진한다.")
    @ValueSource(ints = {4, 7, 9})
    public void goTest(int randomNumber) {
        Position positionBeforeMove = Position.of(0);
        CarName carName = CarName.of("yunb");
        RacingCar racingCar = RacingCar.of(positionBeforeMove, carName);
        racingCar.move(Number.of(randomNumber));
        assertThat(racingCar.getPosition())
                .matches(position -> position.equals(positionBeforeMove.next()));
    }

    @ParameterizedTest(name = "랜덤 값이 4미만인 경우 제자리에 위치한다.")
    @ValueSource(ints = {0, 2, 3})
    public void stopTest(int randomNumber) {
        Position positionBeforeMove = Position.of(0);
        CarName carName = CarName.of("yunb");
        RacingCar racingCar = RacingCar.of(positionBeforeMove, carName);
        racingCar.move(Number.of(randomNumber));
        assertThat(racingCar.getPosition())
                .isEqualTo(positionBeforeMove);
    }

}