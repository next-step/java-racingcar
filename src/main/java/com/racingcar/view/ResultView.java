package com.racingcar.view;

import com.racingcar.game.GameResult;
import com.racingcar.game.RoundResult;

public abstract class ResultView {
    protected GameResult gameResult;

    public ResultView(GameResult gameResult) {
        this.gameResult = gameResult;
    }

    abstract void draw();

    abstract void drawOneRound(RoundResult result);

    protected final String getCarLine(int distance) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < distance; i++) {
            builder.append("-");
        }

       return builder.toString();
    }
}
