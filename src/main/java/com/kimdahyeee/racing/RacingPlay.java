package com.kimdahyeee.racing;

import com.kimdahyeee.racing.rule.RandomStrategy;
import com.kimdahyeee.racing.view.InputView;
import com.kimdahyeee.racing.view.ResultView;

import java.util.List;

public class RacingPlay {

    public static void main(String[] args) {
        List<String> carNames = InputView.getCarNames();
        int tryCount = InputView.getTryCount();

        RacingGame racingGame = new RacingGame(tryCount, carNames, new RandomStrategy());

        ResultView.printHeader(racingGame.getRacingCars());
        while (!racingGame.isEndGame()) {
            ResultView.print(racingGame.move());
        }

        ResultView.printWinner(racingGame.getWinners());
    }

}
