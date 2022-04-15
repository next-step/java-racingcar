package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.MoveStrategy;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RacingCarGameTest {
    private static final int ROUNDS = 5;
    private static final MoveStrategy ALWAYS_MOVE_STRATEGY = () -> true;

    @DisplayName("라운드가 음수면 예외")
    @Test
    void validation() {
        assertThatThrownBy(() -> new RacingCarGame(createCars(), -1, ALWAYS_MOVE_STRATEGY))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isFinished_WhenMoveCarsIsCalledRoundsTimes_True() {
        RacingCarGame game = new RacingCarGame(createCars(), ROUNDS, ALWAYS_MOVE_STRATEGY);

        for (int i = 0; i < ROUNDS; i++) {
            game.moveCars();
        }

        assertThat(game.isFinished()).isTrue();
    }

    @Test
    void isFinished_WhenMoveCarsIsCalledLessThanRoundsTimes_False() {
        RacingCarGame game = new RacingCarGame(createCars(), ROUNDS, ALWAYS_MOVE_STRATEGY);

        for (int i = 0; i < ROUNDS - 1; i++) {
            game.moveCars();
        }

        assertThat(game.isFinished()).isFalse();
    }


    private static Cars createCars() {
        List<String> names = List.of("pobi", "crong", "honux");
        List<Car> carList = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(carList);
    }
}