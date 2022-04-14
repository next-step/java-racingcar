package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.MoveStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarGameTest {

    private static final List<CarName> CAR_NAMES =
            List.of(new CarName("pobi"), new CarName("crong"), new CarName("honux"));
    private static final int ROUNDS = 5;
    private static final MoveStrategy ALWAYS_MOVE_STRATEGY = () -> true;

    @Test
    void proceedRound_DoesNotThrowException_IfRoundsIsGreaterThanZero() {
        RacingCarGame game = createRacingCarGame();

        assertThatNoException().isThrownBy(() -> {
            for (int i = 0; i < ROUNDS; i++) {
                game.proceedRound();
            }
        });
    }

    @Test
    void proceedRound_ThrowsException_IfRoundsIsEqualOrLessThanZero() {
        RacingCarGame game = createRacingCarGame();

        assertThatThrownBy(() -> {
            for (int i = 0; i < ROUNDS + 1; i++) {
                game.proceedRound();
            }
        }).isInstanceOf(IllegalStateException.class);
    }

    private RacingCarGame createRacingCarGame() {
        Cars cars = CarFactory.generateCars(CAR_NAMES);
        return new RacingCarGame(cars, ROUNDS, ALWAYS_MOVE_STRATEGY);
    }
}