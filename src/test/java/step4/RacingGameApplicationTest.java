package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.controller.RacingGameController;
import step4.strategy.MoveStrategy;
import step4.strategy.RandomMoveStrategy;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RacingGameApplicationTest {

    private static final MoveStrategy STRATEGY = new RandomMoveStrategy();

    @ParameterizedTest
    @CsvSource(value = "'hi,ho,hz',5")
    @DisplayName("정상적인 input 값에 대해서 정상적으로 플레이가 되어야 한다.")
    void racingGameTest(String nameInput, int tryCount){
        assertDoesNotThrow(() -> {
            new RacingGameController(nameInput, tryCount, STRATEGY).racingGame();
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"'', 4", "'hi,ho,hz', 0"})
    @DisplayName("정상적이지 못한 input 값에 대해서는 게임이 실행되지 않고 Exception을 내뱉어야 한다.")
    void racingGameWrongInputTest(String nameInput, int tryCount){
        assertThatThrownBy(()-> {
            new RacingGameController(nameInput, tryCount, STRATEGY).racingGame();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}