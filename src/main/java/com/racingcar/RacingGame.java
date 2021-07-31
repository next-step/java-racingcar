package com.racingcar;

import com.racingcar.game.Game;
import com.racingcar.game.GameMaker;
import com.racingcar.view.DefaultInputView;
import com.racingcar.view.InputView;
import com.racingcar.view.ResultView;
import com.racingcar.view.model.GameInput;

public class RacingGame {
    public static void main(String[] args) {
        InputView<GameInput> view = new DefaultInputView();
        GameInput input = view.drawAndParse();

        Game game = GameMaker.make(input.getGameRound(), input.getNumberOfCars());

        int[][] result = game.play();

        ResultView.draw(result);
    }
}
