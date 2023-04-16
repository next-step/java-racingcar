package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.FixedRandomForwardStrategy;
import racing.domain.move.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racing.utils.GameCreateUtil.createGameWithStrategy;

class RacingGameTest {

    @Test
    @DisplayName("경기 생성 테스트")
    void racingGameInfo() {
        List<String> carNames = List.of("pobi", "crong", "honux");
        MoveStrategy moveStrategy = new FixedRandomForwardStrategy(5);
        RacingGame game = createGameWithStrategy(carNames, moveStrategy);
        assertThat(game).isNotNull();

        List<RacingCar> carList = game.getGameCars();
        assertThat(carList.size()).isEqualTo(carNames.size());
        for (int i = 0; i < carNames.size(); i++) {
            assertThat(carList.get(i).name()).isEqualTo(new Name(carNames.get(i)));
            assertThat(carList.get(i).position()).isEqualTo(new Position(0));
        }
    }

    @Test
    @DisplayName("경기 자동차 변경 테스트")
    void changeCarTry() {
        List<String> carNames = List.of("pobi", "crong", "honux");
        MoveStrategy moveStrategy = new FixedRandomForwardStrategy(5);
        RacingGame game = createGameWithStrategy(carNames, moveStrategy);

        RacingCar car = game.getGameCars().get(0);
        car.move();
        assertThat(car.position()).isEqualTo(game.getGameCars().get(0).position());
    }

    @Test
    @DisplayName("경기 우승자 확인 (한 명)")
    void racingGameStartOne() {
        int cycle = 3;
        List<RacingCar> carList = new ArrayList<>();
        carList.add(new RacingCar("pobi", new FixedRandomForwardStrategy(5)));
        carList.add(new RacingCar("crong", new FixedRandomForwardStrategy(0)));
        carList.add(new RacingCar("honux", new FixedRandomForwardStrategy(0)));
        RacingGame game = new RacingGame(carList);

        for (int i = 0; i < cycle; i++) {
            game.progressCycle();
        }

        assertThat(game.getWinnerNames()).containsExactly(new Name("pobi"));
    }

    @Test
    @DisplayName("경기 우승자 확인 (여러 명)")
    void racingGameStartTwo() {
        int cycle = 3;
        List<RacingCar> carList = new ArrayList<>();
        carList.add(new RacingCar("pobi", new FixedRandomForwardStrategy(5)));
        carList.add(new RacingCar("crong", new FixedRandomForwardStrategy(5)));
        carList.add(new RacingCar("honux", new FixedRandomForwardStrategy(0)));
        RacingGame game = new RacingGame(carList);

        for (int i = 0; i < cycle; i++) {
            game.progressCycle();
        }
        System.out.println("game.getWinnerNames() = " + game.getWinnerNames());
        assertThat(game.getWinnerNames()).containsExactly(new Name("pobi"), new Name("crong"));
    }
}