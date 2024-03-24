package RacingGame.View;

import RacingGame.Domain.Car;

import java.util.List;
import java.util.Scanner;

public class OutputView {
    public void OutputView() {
        System.out.println("Result");
    }

    public void PrintResult(int[][] carStatus, List<Car> carList) {
        int trialNum = carStatus[0].length;
        for (int time = 0; time < trialNum; time++) {
            printCars(carStatus, time, carList);
            System.out.println();
        }
    }

    private void printCars(int[][] carStatus, int time, List<Car> carList) {
        int carNum = carStatus.length;
        for (int car = 0; car < carNum; car++) {
            System.out.print(carList.get(car).GetName() + " : ");
            printCarStatus(carStatus[car][time]);
            System.out.println();
        }
    }

    private void printCarStatus(int moveCount) {
        for (int cnt = 0; cnt < moveCount; cnt++) {
            System.out.print("-");
        }
    }

    public void PrintWinner(List<String> winners) {
        for (int i = 0; i < winners.size(); i++) {
            if (i == winners.size() - 1) printName(winners.get(i), false);
            else printName(winners.get(i), true);
        }
        System.out.println("최종 우승했습니다.");
    }

    private void printName(String name, boolean comma) {
        if (comma == true) System.out.print(name + ", ");
        else System.out.print(name + "가 ");
    }
}
