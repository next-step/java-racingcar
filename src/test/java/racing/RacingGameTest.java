package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.RacingCar;
import racing.domain.RacingGame;
import racing.strategy.MoveStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("경기 생성 테스트")
    void racingGameInfo() {
        int car = 5;
        int cycle = 10;
        RacingGame game = new RacingGame(car);
        assertThat(game).isNotNull();

        List<RacingCar> carList = game.getGameCars();
        assertThat(carList.size()).isEqualTo(car);
        for (RacingCar racingCar : carList) {
            assertThat(racingCar).isNotNull();
            assertThat(racingCar.getPosition()).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("경기 시작하기 테스트")
    void racingGameStart() {
        int car = 5;
        int cycle = 3;
        RacingGame game = new RacingGame(car);
        MoveStrategy moveStrategy = new FixedRandomForwardStrategy(5);
        game.setMoveStrategyOfCars(moveStrategy);

        for (int i = 0; i < cycle; i++) {
            game.progressCycle();
        }
        List<Integer> result = game.result();
        for (Integer integer : result) {
            assertThat(integer).isEqualTo(cycle);
        }
    }
}