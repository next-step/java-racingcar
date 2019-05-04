package racing;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingCarTest {
    @Test
    public void 차생성() {
        //given
        //when
        RacingCar car = new RacingCar("m1");

        //then
        assertThat(car).hasNoNullFieldsOrProperties();
    }

    @Test
    public void move_동작_테스트_움직임_조건이_아닐_경우_정지() {
        //given
        RacingCar car = new RacingCar();

        //when
        int result = car.move(() -> false);

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void move_동작_테스트_움직임_조건일_경우_이동() {
        //given
        RacingCar car = new RacingCar();

        //when
        int result = car.move(() -> true);

        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 레이싱카_일급콜렉션_변경() {
        //given
        String names[] = {"m1", "m2"};
        Racing racing = new Racing(names, 3);

        //when
        RacingCars racingCars = racing.getRacingCar();

        //then
        assertThat(racingCars.count()).isEqualTo(2);
    }
}