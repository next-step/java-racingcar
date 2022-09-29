package carRacing.controller;

import carRacing.domain.CarRacingGame;
import carRacing.domain.RacingHistory;
import carRacing.view.InputView;
import carRacing.view.ResultView;

public class CarRacingController {
    public CarRacingController(){
        // 유저로부터 파라미터 입력
        InputView inputView = new InputView();

        // 게임 초기화 및 경주 진행
        CarRacingGame carRacingGame = new CarRacingGame(inputView.getCarNamesString(), inputView.getTryCount());
        RacingHistory racingHistory = carRacingGame.doGame();

        // 결과 출력
        ResultView.displayGameResult(racingHistory);
    }
}
