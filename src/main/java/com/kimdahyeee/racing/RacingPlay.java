package com.kimdahyeee.racing;

import com.kimdahyeee.racing.view.InputView;
import com.kimdahyeee.racing.view.ResultView;

import java.util.Arrays;
import java.util.List;

public class RacingPlay {
    private static final String NAME_SEPARATOR = ",";

    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryCount = InputView.getTryCount();
        RacingGame racingGame = new RacingGame(getCarNames(carNames));

        ResultView.printHeader();

        for (int i = 0; i < tryCount; i++) {
            racingGame.move();
            ResultView.print(racingGame.getRacingCars());
        }

        ResultView.printWinner(racingGame.getWinners());
    }

    private static List<String> getCarNames(String names) {
        if (names == null || names.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        return Arrays.asList(names.split(NAME_SEPARATOR));
    }

}
