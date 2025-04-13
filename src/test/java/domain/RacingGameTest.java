package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    @Test
    @DisplayName("경주게임 생성 테스트")
    public void racingGameTest() {
        Cars cars = new Cars(
            List.of(
                new Car("pobi", new Position(3)),
                new Car("honux", new Position(4)),
                new Car("brown", new Position(5)),
                new Car("jiny", new Position(5))
            )
        );
        RacingGame racingGame = new RacingGame(cars);
        assertThat(racingGame.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("단계별 이동 테스트")
    public void racingGameTest2() {
        Car pobi = new Car("pobi", new Position(1));
        Car brown = new Car("brown", new Position(1));
        Car honux = new Car("honux", new Position(2));
        Option custiomizedOption = new Option(2, 1, 1) {
            @Override
            public boolean getRandomResult() {
                return true;
            }
        };
        RacingGame racingGame = new RacingGame(new Cars(List.of(pobi, brown, honux)), custiomizedOption);
        racingGame.moveByRoundRandomly();
        Assertions.assertAll(
            () -> assertThat(racingGame.findWinners().size()).isEqualTo(1),
            () -> assertThat(racingGame.findWinners()).containsExactlyInAnyOrder(honux)
        );
    }
}
