package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;
import racingcar.model.RacingGame;
import racingcar.model.movestrategy.AlwaysMoveStrategy;
import racingcar.model.movestrategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingGameTest {

    @Test
    @DisplayName("round 횟수는 항상 양수로 입력되어야 함")
    public void validate_round_음수() {
        assertThatThrownBy(() -> new RacingGame(Arrays.asList("a", "b", "c"), -1))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("한 round에는 최대 1칸 이동, 후진 없음")
    public void one_round_이동칸수() {
        MoveStrategy alwaysMoveStrategy = new AlwaysMoveStrategy();
        RacingGame game = new RacingGame(Arrays.asList("a", "b", "c"), 5);
        List<RacingCar> cars = game.cars();

        List<Integer> beforePositions = new ArrayList<>();
        for (RacingCar car : cars) {
            beforePositions.add(car.position().position());
        }
        game.playOneRound(alwaysMoveStrategy);

        for (int i = 0; i < cars.size(); i++) {
            int diff = cars.get(i).position().position() - beforePositions.get(i);
            assertThat(diff).isEqualTo(1);
        }
    }

}
