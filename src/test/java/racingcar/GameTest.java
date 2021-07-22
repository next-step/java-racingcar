package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("[Step3] 게임 (자동차 경주)")
class GameTest {

    @DisplayName("[성공] 게임 진행")
    @ParameterizedTest
    @CsvSource(value = {
        "3,5",
        "5,10"}
    )
    public void doGame(int carCount, int driveCount) {
        // given
        Game game = new Game(carCount, driveCount);

        // when
        game.doGame();

        // then
    }
}
