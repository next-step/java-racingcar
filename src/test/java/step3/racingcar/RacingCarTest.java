package step3.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {
    @Test
    @DisplayName("RacingCar.build 메서드를 사용하면, RacingCar 객체가 만들어 진다.")
    void buildRacingCar() {
        //given
        //when
        RacingCar racingCar = RacingCar.build();
        
        //then
        assertThat(racingCar).isNotNull();
    }

    @Test
    @DisplayName("RacingCar.currentDistance 메서드를 사용하면, 자동차의 전진한 거리를 확인한다.")
    void getCurrentDistanceOfRacingCar() {
        //given
        RacingCar racingCar = RacingCar.build();

        //when
        int currentDistance = racingCar.currentDistance();

        //then
        assertThat(currentDistance).isEqualTo(0);
    }
}
