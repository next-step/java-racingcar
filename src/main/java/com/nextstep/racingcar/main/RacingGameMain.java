package com.nextstep.racingcar.main;

import com.nextstep.racingcar.application.RacingGame;
import com.nextstep.racingcar.domain.car.CarFactory;
import com.nextstep.racingcar.domain.car.MoveStrategy;
import com.nextstep.racingcar.domain.car.RandomMoveCarFactory;
import com.nextstep.racingcar.domain.car.RandomMoveStrategy;
import com.nextstep.racingcar.ui.InputView;
import com.nextstep.racingcar.ui.OutputView;

import java.util.Scanner;

public class RacingGameMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = InputView.create(scanner);

        RacingGame racingGame = new RacingGame(inputView.getCarNumber(), inputView.getRoundNumber());
        CarFactory randomFactory = new RandomMoveCarFactory();
        MoveStrategy moveStrategy = new RandomMoveStrategy();
        racingGame.run(randomFactory, moveStrategy);

        OutputView outputView = new OutputView(racingGame.getResults());
        outputView.printResults();
    }
}
