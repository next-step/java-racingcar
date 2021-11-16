package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.fixture.RacingCarFixture;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingCarsTest {

    @DisplayName("참가자가 1대 미만이면 예외를 발생시킨다.")
    @ParameterizedTest
    @NullAndEmptySource
    void createFailWithNullAndEmptyList(List<RacingCar> values) {
        // when
        ThrowableAssert.ThrowingCallable callable = () -> RacingCars.from(values);

        // then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(callable)
                .withMessageMatching("최소 1대 이상의 자동차가 경주에 참여해야 합니다.");
    }

    @DisplayName("경주용 자동차들은 경주할 수 있다.")
    @Test
    void race() {
        // given
        RacingCars racingCars = RacingCarFixture.RACING_CARS;

        // when
        RacingCars movedRacingCars = racingCars.race();

        // then
        assertAll(
                () -> assertThat(racingCars).isNotEqualTo(movedRacingCars),
                () -> assertThat(racingCars.getValues()).contains(RacingCarFixture.MOVABLE_RACING_CAR, RacingCarFixture.IMMOVABLE_RACING_CAR),
                () -> assertThat(movedRacingCars.getValues()).contains(RacingCarFixture.MOVABLE_RACING_CAR.move(), RacingCarFixture.IMMOVABLE_RACING_CAR.move())
        );
    }
}
