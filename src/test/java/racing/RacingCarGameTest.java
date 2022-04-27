package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.strategies.CarMoveStrategy;
import racing.service.RacingCarGame;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RacingCarGameTest {

    @DisplayName("이동횟수를 1 보다 작게 입력하면 예외를 던진다")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void movesLessThanOne(int numberOfMoves) {
        RacingCarGame game = new RacingCarGame();
        List<String> carNames = List.of("carA", "carB");
        CarHaveToMoveStrategyImpl moveStrategy = new CarHaveToMoveStrategyImpl();
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> game.run(numberOfMoves, carNames, moveStrategy))
                .withMessageMatching("이동횟수는 \\d 이상이어야 합니다");
    }

    @DisplayName("경주 자동차 이름이 null 또는 빈 값이면 예외를 던진다")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyCarNames(List<String> carNames) {
        RacingCarGame game = new RacingCarGame();
        CarHaveToMoveStrategyImpl moveStrategy = new CarHaveToMoveStrategyImpl();
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> game.run(1, carNames, moveStrategy))
                .withMessageMatching("자동차 이름은 필수값입니다");
    }

    @DisplayName("자동차 이동전략이 null 이면 예외를 던진다")
    @ParameterizedTest
    @NullSource
    void nullOrEmptyStrategy(CarMoveStrategy moveStrategy) {
        RacingCarGame game = new RacingCarGame();
        List<String> carNames = List.of("carA", "carB");
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> game.run(1, carNames, moveStrategy))
                .withMessageMatching("이동 전략은 필수값입니다");
    }
}