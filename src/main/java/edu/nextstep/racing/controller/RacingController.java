package edu.nextstep.racing.controller;

import edu.nextstep.racing.domain.MovingCheck;
import edu.nextstep.racing.domain.RacingGame;
import edu.nextstep.racing.view.InputView;
import edu.nextstep.racing.view.ResultView;

public class RacingController {
    private RacingGame racingGame;

    public void setUp(RacingGame racingGame, MovingCheck movingCheck) {
        this.racingGame = racingGame;

        ResultView.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String[] carNames = InputView.splitCarName();

        ResultView.print("시도할 회수는 몇 회 인가요?");
        int gameNum = InputView.inputer();

        racingGame.gameNumCheck(gameNum < 0, "Input Data Error");
        racingGame.setUpRacingCar(carNames);
        racingGame.carMoving(movingCheck, carNames);
        ResultView.winnerNameView(racingGame.getWinnerList());
    }

    public void setUpTest(RacingGame racingGame, MovingCheck movingCheck, String carNames, int gameNum) {
        this.racingGame = racingGame;

        racingGame.gameNumCheck(carNames.isEmpty(), "input data is empty");
        racingGame.setUpRacingCar(carNames.split(","));
        ResultView.winnerNameView(racingGame.getWinnerList());
    }
}
