package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step5.controller.RacingGameController;
import step5.strategy.MoveStrategy;
import step5.strategy.RandomMoveStrategy;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RacingGameApplicationTest {

    private static final MoveStrategy STRATEGY = new RandomMoveStrategy();

    @ParameterizedTest
    @CsvSource(value = "'hi,ho,hz',5")
    void 정상_게임_테스트(String nameInput, int tryCount){
        assertDoesNotThrow(() -> {
            new RacingGameController(nameInput, tryCount, STRATEGY).racingGame();
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"'', 4", "'hi,ho,hz', 0"})
    void 잘못된_게임_테스트(String nameInput, int tryCount){
        assertThatThrownBy(()-> {
            new RacingGameController(nameInput, tryCount, STRATEGY).racingGame();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}