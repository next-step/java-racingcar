package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.MoveStrategy;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RacingCarGameTest {

    private static final List<CarName> CAR_NAMES =
            List.of(new CarName("pobi"), new CarName("crong"), new CarName("honux"));
    private static final int ROUNDS = 5;
    private static final MoveStrategy ALWAYS_MOVE_STRATEGY = () -> true;

    @DisplayName("rounds 만큼 proceedRound() 호출하면 정상동작")
    @Test
    void proceedRound() {
        RacingCarGame game = createRacingCarGame();

        assertThatNoException().isThrownBy(() -> {
            for (int i = 0; i < ROUNDS; i++) {
                game.proceedRound();
            }
        });
    }

    @DisplayName("rounds 보다 proceedRound() 많이 호출하면 예외")
    @Test
    void proceedRound_Exception() {
        RacingCarGame game = createRacingCarGame();

        assertThatThrownBy(() -> {
            for (int i = 0; i < ROUNDS + 1; i++) {
                game.proceedRound();
            }
        }).isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("경주가 끝난 후 getResult()를 통해 우승한 차의 이름을 조회할 수 있다.")
    @Test
    void getResult() {
        RacingCarGame game = createRacingCarGame();
        for (int i = 0; i < ROUNDS; i++) {
            game.proceedRound();
        }

        List<String> winnerNames = game.getResult()
                .getWinnerNames();
        List<String> carNames = CAR_NAMES.stream()
                .map(CarName::getName)
                .collect(Collectors.toList());

        assertThat(winnerNames)
                .containsExactlyInAnyOrderElementsOf(carNames);
    }

    @DisplayName("경주 진행 중에 getResult() 호출하면 예외")
    @Test
    void getResult_Exception() {
        RacingCarGame game = createRacingCarGame();
        for (int i = 0; i < ROUNDS - 1; i++) {
            game.proceedRound();
        }

        assertThatThrownBy(game::getResult)
                .isInstanceOf(IllegalStateException.class);
    }

    private RacingCarGame createRacingCarGame() {
        return new RacingCarGame(CarFactory.generateCars(CAR_NAMES), ROUNDS, ALWAYS_MOVE_STRATEGY);
    }
}