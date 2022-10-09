package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.MovingStrategy;
import racingcar.strategy.RandomMovingStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameFactoryTest {

    @DisplayName("자동차 경주 생성 테스트")
    @Test
    void make() {
        // given
        String racingCarNamesJointComma = "woody,beans,isla";
        int gameTurnCount = 5;

        RacingGameCondition racingGameCondition = new RacingGameCondition(racingCarNamesJointComma, gameTurnCount);
        MovingStrategy movingStrategy = new RandomMovingStrategy();

        // when
        RacingGame racingGame = RacingGameFactory.make(movingStrategy, racingGameCondition);

        // then
        assertThat(racingGame).isInstanceOf(RacingGame.class)
                              .extracting("gameTurnCount")
                              .isEqualTo(5);

        assertThat(racingGame).isInstanceOf(RacingGame.class)
                              .extracting("racingCars")
                              .isEqualTo(List.of(new RacingCar("woody"),
                                      new RacingCar("beans"),
                                      new RacingCar("isla")));

        assertThat(racingGame).isInstanceOf(RacingGame.class)
                              .extracting("racingGameLogStore")
                              .isInstanceOf(RacingGameLogStore.class);
    }
}