package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.random.RacingGameRandomNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {
    @Test
    @DisplayName("입력받은 라운드 수 만큼의 게임결과가 생긴다.")
    void testRoundCount() {
        final RacingCars racingCars = RacingCars.create(
            List.of(
                new RacingCar(new RacingGameRandomNumberGenerator(), "1번자동차"),
                new RacingCar(new RacingGameRandomNumberGenerator(), "2번자동차")
            )
        );
        final RacingGame racingGame = new RacingGame(racingCars, 3);

        final RacingGameResults play = racingGame.play();

        assertThat(play.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("레이싱카가 2대 미만인 경우 예외가 발생한다.")
    void testMinimumCars() {
        final RacingCars racingCars = RacingCars.create(
            List.of(
                new RacingCar(new RacingGameRandomNumberGenerator(), "1번자동차")
            )
        );
        final RacingGame racingGame = new RacingGame(racingCars, 3);

        assertThatThrownBy(racingGame::play)
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}