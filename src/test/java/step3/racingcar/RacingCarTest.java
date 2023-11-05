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
    @DisplayName("currentDistance 메서드를 사용하면, 자동차의 전진한 거리를 확인한다.")
    void getCurrentDistanceOfRacingCar() {
        //given
        RacingCar racingCar = RacingCar.build();

        //when
        int currentDistance = racingCar.currentDistance();

        //then
        assertThat(currentDistance).isEqualTo(0);
    }


    @Test
    @DisplayName("move 메서드의 입력값으로 0이상 3이하의 값이 들어오면, 자동차는 전진하지 않는다.")
    void moveRacingCar_whenInputInRangeZeroToThree() {
        //given
        RacingCar racingCar = RacingCar.build();
        int initDistance = racingCar.currentDistance();

        //when
        racingCar.move(0);
        racingCar.move(1);
        racingCar.move(2);
        racingCar.move(3);

        //then
        assertThat(racingCar.currentDistance()).isEqualTo(initDistance);
    }

    @Test
    @DisplayName("move 메서드의 입력값으로 4이상 9이하의 값이 들어오면, 자동차의 전진한 거리가 1 증가한다.")
    void moveRacingCar_whenInputInRangeFourToNine() {
        //given
        RacingCar racingCar = RacingCar.build();
        int initDistance = racingCar.currentDistance();

        //when
        racingCar.move(4);
        racingCar.move(5);
        racingCar.move(6);
        racingCar.move(7);
        racingCar.move(8);
        racingCar.move(9);

        //then
        assertThat(racingCar.currentDistance()).isEqualTo(initDistance + 6);
    }
}
