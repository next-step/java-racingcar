package racingcar.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.strategy.AlwaysMoveStrategy;
import racingcar.view.ResultView;

import java.util.List;

class RacingGameControllerTest {

    @Test
    @DisplayName("자동차들이 최대 tryCount만큼 움직여야 한다")
    void process() {
        Cars carsForTest = Cars.of(List.of(
                Car.of("pobi"),
                Car.of("crong")
        ));
        int tryCount = 3;
        new RacingGameController(carsForTest, tryCount, new ResultView()).process(new AlwaysMoveStrategy());
        carsForTest.getCarsNameAndPosition().forEach((nameAndPosition) -> {
            int position = nameAndPosition.getSecond().getValue();
            Assertions.assertThat(position).isEqualTo(tryCount);
        });
    }
}
