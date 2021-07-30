package com.racingcar;

import com.racingcar.game.Game;
import com.racingcar.game.GameMaker;
import com.racingcar.view.InputView;
import com.racingcar.view.ResultView;
import com.racingcar.view.model.GameInput;

public class RacingGame {
    public static void main(String[] args) {
        GameInput input = InputView.drawAndParse();

        Game game = GameMaker.make(input.getGameRound(), input.getNumberOfCars());

        int[][] result = game.play();

        ResultView.draw(result);
    }
}
