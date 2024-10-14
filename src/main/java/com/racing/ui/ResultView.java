package com.racing.ui;

import com.racing.domain.Car;

import java.util.List;

public class ResultView {
    public static void printStartMessage() {
        System.out.println("실행 결과");
    }

    public static void printRoundResult(int round, List<Car> carList) {
        System.out.println("# " + round + "회차");
        for (Car car : carList) {
            System.out.println(car.displayRacingState());
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        System.out.print("최종 우승자: ");
        int winnerSize = winners.size();
        for (int i = 0; i < winnerSize; i++) {
            System.out.print(winners.get(i).displayCarName());
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