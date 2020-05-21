package com.kimdahyeee.racing;

import com.kimdahyeee.racing.view.InputView;
import com.kimdahyeee.racing.view.ResultView;

import java.util.List;

public class RacingPlay {

    public static void main(String[] args) {
        List<String> carNames = InputView.getCarNames();
        int tryCount = InputView.getTryCount();

        RacingGame racingGame = new RacingGame(carNames);

        ResultView.printHeader(racingGame.getRacingCars());
        for (int i = 0; i < tryCount; i++) {
            racingGame.move();
            ResultView.print(racingGame.getRacingCars());
        }

        ResultView.printWinner(racingGame.getWinners());
    }

}
