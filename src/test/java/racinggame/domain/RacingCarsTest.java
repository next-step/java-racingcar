package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.support.TestSwitchEngine;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingCarsTest {

    @DisplayName("RacingCars는 한 경기를 수행한 후 경주 자동차들에 대한 결과 스냅샷을 반환한다")
    @Test
    void race() {
        //given
        RacingCars racingCars = new RacingCars(3);
        Engine engine = new TestSwitchEngine(true);

        //when
        RacingGameSnapshot snapshot = racingCars.race(engine);

        //then
        assertThat(snapshot.getCarSnapshots().size()).isEqualTo(3);
    }

}
