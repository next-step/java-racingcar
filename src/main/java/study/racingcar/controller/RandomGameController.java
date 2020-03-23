package study.racingcar.controller;

import study.racingcar.domain.Car;
import study.racingcar.domain.MovableDistance;
import study.racingcar.domain.RacingGame;
import study.racingcar.domain.RacingGameData;
import study.racingcar.view.InputView;
import study.racingcar.view.ResultView;

import java.util.List;

public class RandomGameController {
    private static final String START_GAME_DISPLAY = "실행 결과";

    // static 으로 하는것이 좋을까?
    public void start() {
        List<String> carList = InputView.getCarList();
        int time = InputView.getTime();

        if (carList.isEmpty()) { // todo 만약 null 이라면?
            System.out.println("잘못된 입력입니다.");
            return;
        }

        MovableDistance movableDistance = new RandomMovableDistance();
        RacingGame racingGame =
                new RacingGame(new RacingGameData(carList, time),
                        movableDistance);
        System.out.println(START_GAME_DISPLAY);
        List<Car> cars;
        while (racingGame.isMovable()) {
            cars = racingGame.move();
            ResultView.printCarStatus(cars);
        }

        ResultView.printWinners(racingGame.getWinner());
    }
}
