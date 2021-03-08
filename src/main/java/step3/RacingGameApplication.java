package step3;

import step3.module.CarRacingGame;
import step3.ui.InputView;
import step3.ui.ResultView;
import step3.ui.dto.RequestRacingGame;

import static step3.util.Constants.QUESTION_HOW_MANY_CAR;
import static step3.util.Constants.QUESTION_HOW_MANY_TRY;

/**
 * 레이싱 게임 Application
 */
public class RacingGameApplication {
    public static void main(String[] args) {
        // 사용자 입력
        InputView inputView = new InputView();
        int participants = inputView.requestUserInput(QUESTION_HOW_MANY_CAR);
        int attemptCount = inputView.requestUserInput(QUESTION_HOW_MANY_TRY);

        // 자동차 경주 입력 -> 레이싱 -> 결과
        RequestRacingGame userRequest = new RequestRacingGame(participants, attemptCount);

        // 레이싱 게임 시작
        CarRacingGame racingGame = new CarRacingGame(userRequest);
        racingGame.race();

        ResultView resultView = new ResultView();
        resultView.responseResult(racingGame.getRacingResult());
    }
}
