package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Racing;
import racingcar.domain.RacingCars;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {
    @Test
    @DisplayName("자동차 객체 여러개 생성 되는지 확인")
    public void checkRacingCarsObject() {
        String[] test = new String[]{"pobi", "next", "step", "fight", "test"};
        RacingCars racingCars = new RacingCars(test);

        assertThat(racingCars.statusOfRacingCars()).hasSize(5);
    }


}