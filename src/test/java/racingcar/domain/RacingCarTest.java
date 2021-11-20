package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.strategy.MockRandomMovingStrategy;
import racingcar.fixture.RacingCarFixture;

class RacingCarTest {

    @DisplayName("4보다 작은 값이 나오면 자동차는 움직일 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void moveFalse(int value) {
        // given
        MockRandomMovingStrategy strategy = new MockRandomMovingStrategy(value);
        RacingCar car = new RacingCar(RacingCarFixture.PARTICIPANT_NAME, Position.ZERO_POSITION, strategy);

        // when
        RacingCar moved = car.move();

        // then
        Assertions.assertThat(car).isEqualTo(moved);
    }

    @DisplayName("4이상의 값이 나오면 자동차는 움직일 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 100})
    void move(int value) {
        // given
        MockRandomMovingStrategy strategy = new MockRandomMovingStrategy(value);
        RacingCar car = new RacingCar(RacingCarFixture.PARTICIPANT_NAME, Position.ZERO_POSITION, strategy);
        RacingCar expect = new RacingCar(RacingCarFixture.PARTICIPANT_NAME, Position.ZERO_POSITION.move(), strategy);

        // when
        RacingCar moved = car.move();

        // then
        Assertions.assertThat(moved).isEqualTo(expect);
    }
}
