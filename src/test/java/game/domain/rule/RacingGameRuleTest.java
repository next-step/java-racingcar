package game.domain.rule;

import game.domain.game.RacingGame;
import game.domain.car.RacingGameCarList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameRuleTest {

    @DisplayName("forwardNumber 이상의 값이 전달되면 True를 이하면 False를 반환한다.")
    @Test
    void isForward() {
        RacingGameRule racingGameRule = new RacingGameRule(4, 10);

        Assertions.assertAll(
                () -> assertThat(racingGameRule.isForward(4)).isEqualTo(true),
                () -> assertThat(racingGameRule.isForward(66)).isEqualTo(true),
                () -> assertThat(racingGameRule.isForward(3)).isEqualTo(false)
        );
    }

    @DisplayName("racingGameRule의 범위 안에 있는 숫자를 뽑는다.")
    @RepeatedTest(10)
    void pickRandomNumber() {
        RacingGameRule racingGameRule = new RacingGameRule(4, 6);
        RacingGame racingGame = new RacingGame(racingGameRule, RacingGameCarList.makeRacingGameCars(3), 3);

        org.assertj.core.api.Assertions.assertThat(racingGame.pickRandomNumber()).isBetween(0, racingGameRule.bound());
    }
}
