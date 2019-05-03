package racing;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingCarTest {
    @Test
    public void move_동작_테스트_움직임_조건이_아닐_경우_정지() {
        //given
        RacingCar car = new RacingCar();

        //when
        int result = car.move2(() -> false);

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void move_동작_테스트_움직임_조건일_경우_이동() {
        //given
        RacingCar car = new RacingCar();

        //when
        int result = car.move2(() -> true);

        //then
        assertThat(result).isEqualTo(1);
    }

    @Test(expected = ClassCastException.class)
    public void 레이싱카_외부에서_변경_못하게_설정() {
        //given
        Racing racing = new Racing(2, 3);

        //when
        List<RacingCar> racingCars = racing.getRacingCars();

        //then
        racingCars.add(new RacingCar());
    }
}