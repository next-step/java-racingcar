package com.racingcar;

import com.racingcar.game.Game;
import com.racingcar.game.GameMaker;
import com.racingcar.view.InputView;
import com.racingcar.view.model.GameInputDto;

public class RacingGame {
    public static void main(String[] args) {
        GameInputDto input = InputView.drawAndParse();

        Game game = GameMaker.make(input);

        game.play();
    }
}
