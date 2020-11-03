package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.car.moving.DefaultMovingSuccessStrategy;
import study.racingcar.configuration.DefaultGameConfiguration;
import study.racingcar.view.DefaultInputView;
import study.racingcar.view.DefaultResultView;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("게임은 모든 시도를 해야 한다.")
    void test_racingGame_default() {

        // Given
        DefaultGameConfiguration defaultGameConfiguration
                = new DefaultGameConfiguration(new DefaultInputView()
                , 3, 5, DefaultMovingSuccessStrategy.getInstance());

        RacingGame racingGame = new RacingGame(defaultGameConfiguration, new DefaultResultView());

        // When
        GameResult gameResult = racingGame.startGame();

        // Then
        assertThat(gameResult.hasMoreThanEqual(5).isEmpty())
                .isFalse();
    }


}