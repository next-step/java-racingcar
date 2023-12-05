package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;
import racingcar.model.Referee;
import racingcar.model.movestrategy.AlwaysMoveStrategy;
import racingcar.model.movestrategy.AlwaysStopStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {

    @Test
    @DisplayName("position 값이 제일 높은 차가 우승")
    public void 우승자_확인() {
        RacingCar car1 = new RacingCar("abc");
        RacingCar car2 = new RacingCar("def");
        List<RacingCar> cars = Arrays.asList(car1, car2);

        car1.moveOrStop(new AlwaysStopStrategy());
        car2.moveOrStop(new AlwaysMoveStrategy());

        Referee referee = new Referee();

        assertThat(referee.findWinner(cars))
                .containsOnly(car2);
    }

    @Test
    @DisplayName("position 값이 가장 높은 차가 여러 대일 경우 공동 우승")
    public void 공동우승() {
        RacingCar car1 = new RacingCar("abc");
        RacingCar car2 = new RacingCar("def");
        RacingCar car3 = new RacingCar("ghi");
        List<RacingCar> cars = Arrays.asList(car1, car2, car3);

        car1.moveOrStop(new AlwaysStopStrategy());
        car2.moveOrStop(new AlwaysMoveStrategy());
        car3.moveOrStop(new AlwaysMoveStrategy());

        Referee referee = new Referee();

        assertThat(referee.findWinner(cars))
                .containsExactly(car2, car3);
    }

}
