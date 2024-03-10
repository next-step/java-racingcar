package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.view.ResultView;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameTest {

    @Test
    @DisplayName("레이싱 경주 시작 메서드 호출 성공 (모든 자동차들이 항상 움직임)")
    void racingGame__ShouldMoveAllCars() {
        // given
        int numberOfCars = 3;
        int numberOfAttempts = 5;
        CarMovementStrategy carMovementStrategy = () -> true;

        // when
        RacingGame racingGame = new RacingGame(numberOfCars, carMovementStrategy);
        ResultView resultView = racingGame.getResult(numberOfAttempts);
        String[] resultLines = resultView.getResult().split("\n");

        // then
        // 3 * 5 + 한줄 공백 4개 + "실행결과" = 20
        assertEquals(20, resultLines.length);
    }

}
