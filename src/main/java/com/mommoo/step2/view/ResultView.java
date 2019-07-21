package com.mommoo.step2.view;

import com.mommoo.step2.Car;
import com.mommoo.step2.domain.CarWinnerComputer;

import java.util.List;

public class ResultView {
    private static final String LINE = "-";

    private ResultView() {
        /* prevent creating instance */
    }

    public static void printCarMoveLine(Car car) {
        StringBuilder builder = new StringBuilder();

        builder.append(car.getName())
               .append(" : ");

        int moveCount = car.getPosition();

        while (moveCount-- > 0) {
            builder.append(LINE);
        }
        System.out.println(builder);
    }

    public static void printFinalWinner(CarWinnerComputer carWinnerComputer) {
        StringBuilder builder = new StringBuilder();

        if (carWinnerComputer.isWinnerNotExist()) {
            System.out.println("우승자가 없습니다.");
            return;
        }

        List<String> winnerCarNameList = carWinnerComputer.getWinnerCarNames();

        String prefixCarNames = String.join(",", winnerCarNameList);

        builder.append(prefixCarNames)
               .append("가 최종 우승했습니다.");

        System.out.println(builder);
    }
}
