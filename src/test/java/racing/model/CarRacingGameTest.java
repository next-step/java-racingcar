package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("CarRacingGame 단위 테스트")
class CarRacingGameTest {

    private final List<String> carNames = Arrays.asList("1", "2", "3");

    @Test
    void moveCars() {
        CarRacingGame carRacingGame = new CarRacingGame(carNames, 1);

        assertThatCode(carRacingGame::moveCars)
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("moveCars() - IllegalStateException 생성")
    void moveCarsIllegalStateException() {
        CarRacingGame carRacingGame = new CarRacingGame(carNames, 0);

        assertThatIllegalStateException()
                .isThrownBy(carRacingGame::moveCars);
    }

    @Test
    void isPossibleMove() {
        CarRacingGame carRacingGame1 = new CarRacingGame(carNames, 0);
        assertThat(carRacingGame1.isPossibleToMove())
                .isFalse();

        CarRacingGame carRacingGame2 = new CarRacingGame(carNames, 1);
        assertThat(carRacingGame2.isPossibleToMove())
                .isTrue();

    }
}