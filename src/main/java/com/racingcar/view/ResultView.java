package com.racingcar.view;

import com.racingcar.game.GameResult;
import com.racingcar.game.RoundResult;

import java.util.List;

public class ResultView {
    public static void draw(GameResult result) {
        System.out.println("실행 결과");

        for (int i = 0; i < result.getRoundSize(); i++) {
            drawOneRound(result.getRoundResult(i), result.getCarIdList());
            System.out.println();
        }
    }

    private static void drawOneRound(RoundResult result, List<Integer> carIds) {
        for(int id : carIds) {
            drawCar(result.get(id));
        }
    }

    private static void drawCar(int distance) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < distance; i++) {
            builder.append("-");
        }

        System.out.println(builder.toString());
    }
}
