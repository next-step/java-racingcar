package study.step4.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step4.controller.CarsPositionModel;
import study.step4.domain.Cars;
import study.step4.util.TestMoveStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

@DisplayName("레이싱 게임 테스트")
class RacingGameTest {

    @DisplayName("레이싱 자동차 전진 테스트")
    @Test
    void play() {
        var carNames = new String[]{"a", "b", "c"};
        Cars cars = new Cars(carNames);

        RacingGame racingGame = new RacingGame(cars, new GameCount(1));

        List<CarsPositionModel> result = racingGame.play(new TestMoveStrategy(4));
        assertThat(result)
                .extracting("carName", "position")
                .contains(tuple("a", 1), tuple("b", 1),tuple("c", 1));

    }

    @DisplayName("게임 종료 테스트")
    @Test
    void nextGame() {
        var carNames = new String[]{"a", "b", "c"};
        Cars cars = new Cars(carNames);
        RacingGame racingGame = new RacingGame(cars, new GameCount(4));

        racingGame.play(new TestMoveStrategy(4));
        racingGame.play(new TestMoveStrategy(4));
        racingGame.play(new TestMoveStrategy(4));
        racingGame.play(new TestMoveStrategy(4));
        racingGame.play(new TestMoveStrategy(4));

        assertThat(racingGame.isPlay()).isTrue();
    }

    @DisplayName("우승자 테스트")
    @Test
    void winners() {
        var carNames = new String[]{"a", "b", "c"};
        Cars cars = new Cars(carNames);
        RacingGame racingGame = new RacingGame(cars, new GameCount(2));

        racingGame.play(new TestMoveStrategy(4));
        racingGame.play(new TestMoveStrategy(4));

        assertThat(racingGame.winners()).isEqualTo(Arrays.asList("a", "b", "c"));

    }
}