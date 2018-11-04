package racingcar;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {

    @Test
    public void 레이싱카를_생성할수있다() {
        RacingCar racingCar = RacingCar.create();
        assertThat(racingCar).isNotNull();
    }

    @Test
    public void 여러개의_레이싱카를_생성할수있다() {
        int numberOfCar = 5;
        List<RacingCar> racingCars = RacingCar.create(numberOfCar);
        assertThat(racingCars).isNotNull();
        assertThat(racingCars.size()).isEqualTo(numberOfCar);
    }

    @Test
    public void 레이싱카의_처음위치는_1이다() {
        RacingCar racingCar = RacingCar.create();
        assertThat(racingCar.getPosition()).isEqualTo(1);
    }

    @Test
    public void 레이싱카는_이동할수있다() {
        RacingCar racingCar = RacingCar.create();
        racingCar.move();
        assertThat(racingCar.getPosition()).isEqualTo(2);
    }

    @Test
    public void 레이싱카는_원하는만큼_이동할수있다() {
        int count = 5;
        RacingCar racingCar = RacingCar.create();
        racingCar.move(count);
        assertThat(racingCar.getPosition()).isEqualTo(count + 1);
    }
}