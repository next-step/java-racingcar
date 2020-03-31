package study.racingcar.controller;

import study.racingcar.domain.*;
import study.racingcar.view.InputView;
import study.racingcar.view.ResultView;

import java.util.List;

public class RacingGameController {
    public void start() {
        List<String> carNames = InputView.getCarList();
        int time = InputView.getTime();

        MovableDistance movableDistance = new RandomMovableDistance();
        RacingGame racingGame =
                new RacingGame(carNames, movableDistance);
        RacingGameResult racingGameResult = racingGame.play(time);
        ResultView.displayGameResult(racingGameResult);
    }
}
