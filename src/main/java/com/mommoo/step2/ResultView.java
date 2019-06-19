package com.mommoo.step2;

import java.util.List;

public class ResultView {
    private static final String LINE = "-";
    private final StringBuilder BUILDER = new StringBuilder();

    public void printCarMoveLine(Car car) {
        BUILDER.setLength(0);

        BUILDER.append(car.getName())
               .append(" : ");

        int moveCount = car.getPosition();
        while (moveCount-- > 0) {
            BUILDER.append(LINE);
        }
        System.out.println(BUILDER);
    }

    public void printFinalWinner(List<Car> cars) {
        CarWinnerComputer carWinnerComputer = new CarWinnerComputer(cars);

        if (carWinnerComputer.isWinnerNotExist()) {
            System.out.println("우승자가 없습니다.");
            return;
        }

        List<String> winnerCarNameList = carWinnerComputer.getWinnerCarNameList();

        String prefixCarNames = String.join(",", winnerCarNameList);

        BUILDER.setLength(0);

        BUILDER.append(prefixCarNames)
               .append("가 최종 우승했습니다.");

        System.out.println(BUILDER);
    }
}
