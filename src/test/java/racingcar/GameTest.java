package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("[Step3] 게임 (자동차 경주)")
class GameTest {

    @DisplayName("[성공] 게임 진행")
    @ParameterizedTest
    @CsvSource(value = {
        "pobi,crong,honux:5"}, delimiter = ':'
    )
    public void doGame(String carNames, int driveCount) {
        // given
        Game game = new Game(carNames, driveCount);

        // when
        game.doGame();

        // then
    }
}
