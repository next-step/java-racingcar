package com.racingcar;

import com.racingcar.game.RacingGame;
import com.racingcar.game.GameMaker;
import com.racingcar.view.InputView;
import com.racingcar.view.model.GameInputDto;

public class RacingGameController {
    public static void main(String[] args) {
        GameInputDto input = InputView.drawAndParse();

        RacingGame racingGame = GameMaker.make(input);

        racingGame.play();
    }
}
