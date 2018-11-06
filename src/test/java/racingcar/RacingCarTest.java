package racingcar;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {

    @Test
    public void 레이싱카를_생성할수있다() {
        RacingCar racingCar = RacingCar.create("pobi");
        assertThat(racingCar).isNotNull();
    }

    @Test
    public void 여러개의_레이싱카를_생성할수있다() {
        List<String> racingCarNames = Arrays.asList("foo", "bar");

        List<RacingCar> racingCars = RacingCar.create(racingCarNames);
        assertThat(racingCars).isNotNull();
        assertThat(racingCars.size()).isEqualTo(racingCarNames.size());
    }

    @Test
    public void 레이싱카의_처음위치는_1이다() {
        RacingCar racingCar = RacingCar.create("pobi");
        assertThat(racingCar.getPosition()).isEqualTo(1);
    }
}