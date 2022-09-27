package game.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("racingGameRule의 범위 안에 있는 숫자를 뽑는다.")
    @RepeatedTest(10)
    void pickRandomNumber() {
        RacingGameRule racingGameRule = new RacingGameRule(4, 6);
        RacingGame racingGame = new RacingGame(racingGameRule, CarList.makeCars(3), 3);

        Assertions.assertThat(racingGame.pickRandomNumber()).isBetween(0, racingGameRule.bound());
    }

    @DisplayName("RacingGameRule에 따라서 자동차의 위치를 변경한다.")
    @Test
    void forwardByRule() {
        RacingGameRule racingGameRule = new RacingGameRule(4, 10);
        RacingGame racingGame = new RacingGame(racingGameRule, CarList.makeCars(3), 3);
        Car car = racingGame.carList().cars().get(0);

        org.junit.jupiter.api.Assertions.assertAll(
                () -> {
                    racingGame.forwardByRule(car, racingGameRule.canForwardNumber() - 1);
                    assertThat(car.location()).isEqualTo(car.location());
                },
                () -> {
                    int expected = car.location() + racingGameRule.forwardDistance();
                    racingGame.forwardByRule(car, racingGameRule.canForwardNumber());
                    assertThat(car.location()).isEqualTo(expected);
                }
        );
    }

}
