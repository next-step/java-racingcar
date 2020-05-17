package com.nextstep.racingcar.view;

import com.nextstep.racingcar.application.RacingGame;
import com.nextstep.racingcar.domain.car.CarFactory;
import com.nextstep.racingcar.domain.car.MoveStrategy;
import com.nextstep.racingcar.domain.car.RandomMoveStrategy;

import java.util.Scanner;

public class UiController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = InputView.create(scanner);

        RacingGame racingGame = new RacingGame(inputView.getDriverNames(), inputView.getRoundNumber());
        CarFactory randomFactory = new CarFactory();
        MoveStrategy moveStrategy = new RandomMoveStrategy();
        racingGame.runByDriversName(randomFactory, moveStrategy);

        OutputView outputView = new OutputView(racingGame.getRacingGameResult());
        System.out.println(outputView.toStringResult());
        System.out.println(outputView.toStringWinner());
    }
}
