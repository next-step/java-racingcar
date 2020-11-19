package study.step5.controller;

import study.step5.domain.Cars;
import study.step5.domain.RacingGame;
import study.step5.view.InputView;
import study.step5.view.ResultView;

public class RacingGameController {
    public static void main(String[] args) {
        // 자동차 세팅
        String carNames = InputView.inputCars();
        Cars cars = new Cars(carNames);

        // 기회 세팅
        int raceCount = InputView.inputRacingCount();
        // 경주 시작
        RacingGame racingGame = new RacingGame();
        for (int i = 0; i < raceCount; i++) {
            racingGame.start(cars);
            ResultView.printCarsScore(cars);
        }
        // 우승자 출력
        ResultView.printCarsScore(cars);
        ResultView.printWinner(cars);
    }
}
