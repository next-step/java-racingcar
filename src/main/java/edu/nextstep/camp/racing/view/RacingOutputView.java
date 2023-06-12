package edu.nextstep.camp.racing.view;

import edu.nextstep.camp.racing.domain.Car;

import java.util.List;

public class RacingOutputView extends OutputView{

    private static final String POSITION_BAR = "-";

    private static final String WINNER_GUIDE_MSG = "(이)가 최종 우승했습니다.";

    public static void printCurrentPosition(Car car) {
        String name = car.getName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name)
                .append(": ")
                .append(POSITION_BAR.repeat(car.currentPosition()));

        print(stringBuilder.toString());
    }

    public static void printWinners(List<String> winners) {
        print(String.join(",", winners) + WINNER_GUIDE_MSG);
    }
}
