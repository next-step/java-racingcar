package edu.nextstep.camp.racing.view;

import edu.nextstep.camp.racing.domain.Car;

public class RacingOutputView extends OutputView{

    private static final String POSITION_BAR = "-";
    private static final String NEXT_LINE = "\n";

    public static void printCurrentPosition(Car car) {
        String name = car.getName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name)
                .append(": ")
                .append(POSITION_BAR.repeat(car.currentPosition()))
                .append(NEXT_LINE);

        print(stringBuilder.toString());
    }

}
