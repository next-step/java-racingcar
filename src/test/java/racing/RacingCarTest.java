package racing;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingCarTest {
    @Test
    public void move_동작_테스트_움직임_조건_4미만인_경우_정지() {
        RacingCar car = new RacingCar();

        int result = car.move(3);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void move_동작_테스트_움직임_조건_4이상인_경우_이동() {
        RacingCar car = new RacingCar();

        int result = car.move(4);
        assertThat(result).isEqualTo(1);
    }

    @Test(expected =  ClassCastException.class)
    public void 레이싱카_외부에서_변경_못하게_설정() {
        Racing racing = new Racing(2, 3);
        List<RacingCar> racingCars = racing.getRacingCars();
        racingCars.add(new RacingCar());
    }
}