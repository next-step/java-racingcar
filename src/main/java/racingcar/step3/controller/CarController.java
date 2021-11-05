package racingcar.step3.controller;

import racingcar.step3.AppConfig;
import racingcar.step3.validator.CarValidator;
import racingcar.step3.view.InputView;
import racingcar.step3.service.RacingGame;
import racingcar.step3.view.ResultView;
import racingcar.step3.domain.Cars;
import racingcar.step3.move.Moving;

public class CarController {

    public static void main(String[] args) {
        //인풋 출력
        InputView inputView = new InputView();
        int countOfCar = inputView.countOfCar();
        int countOfTry = inputView.countOfTry();

        //검증
        CarValidator.countOfCarCheck(countOfCar);
        CarValidator.countOfTryCheck(countOfTry);

        //아웃풋 출력
        ResultView resultView = new ResultView();
        resultView.executeMessage();

        // 랜덤무빙 구현 객체 가져옴
        AppConfig appConfig = new AppConfig();
        Moving moving = appConfig.move();

        Cars cars = new Cars(countOfCar);
        RacingGame racingGame = new RacingGame(countOfTry, cars);

        if (!racingGame.isEndGame()) {
            for (int i = 0; i < countOfTry; i++) {
                // 아웃풋 풀력
                resultView.resultPrint(cars);
                racingGame.race(moving);
            }
        }
    }

}
