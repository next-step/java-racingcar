package com.racingcar.view;

import com.racingcar.car.NamedCar;
import com.racingcar.game.GameResult;
import com.racingcar.game.RoundResult;

import java.util.List;
import java.util.stream.Collectors;

public class NamedCarResultView extends ResultView {
    private static final String CAR_NAME_SPLITER = " : ";

    public NamedCarResultView(GameResult gameResult) {
        super(gameResult);
    }

    @Override
    public void draw() {
        System.out.println("실행 결과");

        for (int i = 0; i < gameResult.getRoundSize(); i++) {
            drawOneRound(gameResult.getRoundResult(i));
            System.out.println();
        }

        drawWinners();
    }

    @Override
    void drawOneRound(RoundResult result) {
        for (int id : result.getCarIdList()) {
            NamedCar car = (NamedCar) gameResult.getCar(id);

            StringBuilder builder = new StringBuilder();
            String line = builder.append(car.getName())
                    .append(CAR_NAME_SPLITER)
                    .append(getCarLine(result.get(id)))
                    .toString();

            System.out.println(line);
        }
    }

    private void drawWinners() {
        StringBuilder builder = new StringBuilder();
        builder.append(extractWinnerNames())
                .append("가 최종 우승했습니다.");
        System.out.println(builder.toString());
    }

    private String extractWinnerNames() {
        List<NamedCar> winners = gameResult.getWinners();
        return winners.stream()
                .map(NamedCar::getName)
                .collect(Collectors.joining(","));
    }
}
