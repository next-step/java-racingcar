package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.FixedRandomForwardStrategy;
import racing.domain.move.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racing.utils.GameCreateUtil.createGameWithStrategy;

class GameTest {

    @Test
    @DisplayName("경기 생성 테스트")
    void racingGameInfo() {
        List<String> carNames = List.of("pobi", "crong", "honux");
        MoveStrategy moveStrategy = new FixedRandomForwardStrategy(5);
        Game game = createGameWithStrategy(carNames, moveStrategy);
        assertThat(game).isNotNull();
    }

    @Test
    @DisplayName("경기 우승자 확인 (한 명)")
    void racingGameStartOne() {
        int cycle = 3;
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi", new FixedRandomForwardStrategy(5)));
        carList.add(new Car("crong", new FixedRandomForwardStrategy(0)));
        carList.add(new Car("honux", new FixedRandomForwardStrategy(0)));
        Game game = new Game(carList);

        for (int i = 0; i < cycle; i++) {
            game.progressCycle();
        }

        assertThat(game.getWinnerNames()).containsExactly(new Name("pobi"));
    }

    @Test
    @DisplayName("경기 우승자 확인 (여러 명)")
    void racingGameStartTwo() {
        int cycle = 3;
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi", new FixedRandomForwardStrategy(5)));
        carList.add(new Car("crong", new FixedRandomForwardStrategy(5)));
        carList.add(new Car("honux", new FixedRandomForwardStrategy(0)));
        Game game = new Game(carList);

        for (int i = 0; i < cycle; i++) {
            game.progressCycle();
        }
        System.out.println("game.getWinnerNames() = " + game.getWinnerNames());
        assertThat(game.getWinnerNames()).containsExactly(new Name("pobi"), new Name("crong"));
    }
}