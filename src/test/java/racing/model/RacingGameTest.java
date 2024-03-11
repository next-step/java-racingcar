package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.view.ResultView;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameTest {

    @Test
    @DisplayName("레이싱 경주 시작 메서드 호출 성공 (모든 자동차들이 항상 움직임)")
    void racingGame__ShouldMoveAllCars() {
        // given
        int numberOfCars = 3;
        int numberOfAttempts = 5;
        ResultView resultView = new ResultView();
        CarMovementStrategy carMovementStrategy = () -> true;

        // when
        RacingGame racingGame = new RacingGame(numberOfCars, carMovementStrategy);
        List<Car> raceDoneCars = racingGame.getResult(numberOfAttempts);
        String result = resultView.getResultView(raceDoneCars, numberOfAttempts);
        String[] resultLines = result.split("\n");

        // then
        // 3 * 5 + 한줄 공백 4개 + "실행결과" = 20
        assertEquals(20, resultLines.length);
    }

}
