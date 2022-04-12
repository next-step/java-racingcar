package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.domain.strategy.RandomMoveStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingCarGameTest {

    private static final int carSize = 10;
    private static final int rounds = 10;

    @Test
    void rounds_만큼_proceedRound_호출하면_정상동작() {
        RacingCarGame game = generateGame(new RandomMoveStrategy());
        assertThatNoException().isThrownBy(() -> {
            for (int i = 0; i < rounds; i++) {
                game.proceedRound();
            }
        });
    }

    @Test
    void rounds_보다_proceedRound_많이_호출하면_예외() {
        RacingCarGame game = generateGame(new RandomMoveStrategy());
        assertThatThrownBy(() -> {
            for (int i = 0; i < rounds + 1; i++) {
                game.proceedRound();
            }
        }).isInstanceOf(IllegalStateException.class);
    }

    private RacingCarGame generateGame(MoveStrategy strategy) {
        List<Car> cars = CarFactory.generateCarsOfSize(carSize);
        return new RacingCarGame(cars, rounds, strategy);
    }
}