package com.racing.ui;

import com.racing.domain.Car;
import com.racing.domain.Cars;

public class ResultView {
    public static void printStartMessage() {
        System.out.println("실행 결과");
    }

    public static void printRoundResult(int round, Cars cars) {
        System.out.println("# " + round + "회차");
        for (Car car : cars.getCarList()) {
            System.out.println(car.displayRacingPosition());
        }
        System.out.println();
    }

    public static void printWinners(Cars winners) {
        System.out.print("최종 우승자: ");
        int winnerSize = winners.getCarList().size();
        for (int i = 0; i < winnerSize; i++) {
            System.out.print(winners.getCarList().get(i).displayCarName());
            printComma(i < winnerSize - 1);
        }

        System.out.println();
    }

    private static void printComma(boolean isComma) {
        if (isComma) {
            System.out.print(", ");
        }
    }
}