package com.racingcar;

import com.racingcar.game.GameMaker;
import com.racingcar.game.RacingGame;
import com.racingcar.view.GameDrawer;
import com.racingcar.view.InputView;
import com.racingcar.view.model.GameInputDto;

public class RacingGameController {
    public static void main(String[] args) {
        GameInputDto input = InputView.drawAndParse();

        RacingGame racingGame = GameMaker.make(input);

        GameDrawer.drawGameStart();

        while (racingGame.isNotGameFinished()) {
            GameDrawer.drawOneRound(racingGame.playOneRound());
        }

        GameDrawer.drawWinners(racingGame.getWinners());
    }
}
