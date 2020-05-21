package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.car.RacingCars;
import racinggame.domain.result.RacingGameSnapshot;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingCarsTest {

    @DisplayName("RacingCars는 한 경기를 수행한 후 경주 자동차들에 대한 결과 스냅샷을 반환한다")
    @Test
    void race() {
        //given
        RacingCars racingCars = new RacingCars(Arrays.asList("a", "b", "c"));

        //when
        RacingGameSnapshot snapshot = racingCars.race(new TestSwitchEngine());

        //then
        assertAll(
                () -> assertThat(snapshot.getCarSnapshots().size()).isEqualTo(3),
                () -> assertThat(snapshot.findWinners()).isEqualTo(Arrays.asList("a", "c"))
        );
    }
}
