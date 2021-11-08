package racingcar.step3.controller;

import racingcar.step3.config.MoveConfig;
import racingcar.step3.view.InputView;
import racingcar.step3.service.RacingGame;
import racingcar.step3.view.ResultView;
import racingcar.step3.move.Moving;

public class CarController {

    public static void main(String[] args) {
        //인풋 출력
        InputView inputView = new InputView();
        int countOfCar = inputView.countOfCar();
        int countOfTry = inputView.countOfTry();

        // 랜덤무빙 구현 객체 가져옴
        MoveConfig moveConfig = new MoveConfig();
        Moving moving = moveConfig.move();

        RacingGame racingGame = new RacingGame(countOfTry, countOfCar);

        //아웃풋 출력
        ResultView resultView = new ResultView();
        resultView.executeMessage();

        // 레이싱 스타트
        while (!racingGame.isEndGame()) {
            resultView.resultPrint(racingGame.getCars());
            racingGame.race(moving);
        }
    }

}
