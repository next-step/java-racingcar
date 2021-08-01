package com.racingcar;

import com.racingcar.game.*;
import com.racingcar.view.InputView;
import com.racingcar.view.NamedCarInputView;
import com.racingcar.view.NamedCarResultView;
import com.racingcar.view.model.GameInput;

public class RacingGame {
    public static void main(String[] args) {
        InputView view = new NamedCarInputView();
        GameInput input = view.drawAndParse();

        CarsMakeRule makeCarsRule = new NamedCarsMakeRule();

        GameMaker gameMaker = new GameMaker(makeCarsRule);

        Game game = gameMaker.make(input.getGameRound(), input.getCarInput());

        GameResult result = game.play();

        NamedCarResultView resultView = new NamedCarResultView(result);
        resultView.draw();
    }
}
