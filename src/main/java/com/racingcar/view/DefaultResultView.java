package com.racingcar.view;

import com.racingcar.game.GameResult;
import com.racingcar.game.RoundResult;

public class DefaultResultView extends ResultView {
    public DefaultResultView(GameResult gameResult) {
        super(gameResult);
    }

    @Override
    public void draw() {
        System.out.println("실행 결과");

        for (int i = 0; i < gameResult.getRoundSize(); i++) {
            drawOneRound(gameResult.getRoundResult(i));
            System.out.println();
        }
    }

    @Override
    void drawOneRound(RoundResult result) {
        for (int id : result.getCarIdList()) {
            String line = getCarLine(result.get(id));

            System.out.println(line);
        }
    }
}
