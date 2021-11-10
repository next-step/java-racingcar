package racingcar.step5.controller;

import racingcar.step5.config.MoveConfig;
import racingcar.step5.domain.MovingStrategy;
import racingcar.step5.domain.RacingGame;
import racingcar.step5.view.InputView;
import racingcar.step5.view.ResultView;

public class CarController {

    public static void main(String[] args) {
        // 인풋 출력
        InputView inputView = new InputView();
        String carName =  inputView.getCarName();
        int countOfTry = inputView.countOfTry();

        // 랜덤무빙 구현 객체 가져옴
        MoveConfig moveConfig = new MoveConfig();
        MovingStrategy moving = moveConfig.move();

        RacingGame racingGame = new RacingGame(carName, countOfTry);

        // 레이싱 스타트
        ResultView resultView = new ResultView();
        resultView.executeMessage();
        while (!racingGame.isEndGame()) {
            racingGame.race(moving);
            resultView.printResult(racingGame.getCars());
        }

        // 우승자 출력
        resultView.printWinners(racingGame);
    }

}
