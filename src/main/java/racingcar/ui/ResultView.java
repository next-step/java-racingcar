package racingcar.ui;

import racingcar.Car;

import java.util.List;

public class ResultView {

    public void print(List<Car> cars, int tryCount) {
        System.out.println("\n실행 결과");

        for (int round = 0; round < tryCount; round++) {
            printByRound(cars, round);
        }
    }

    private void printByRound(List<Car> cars, int round) {
        System.out.println("== ROUND " + (round+1) + " ==");
        for (Car car : cars) {
            printPosition(car.getCarPositions().get(round));
            System.out.println();
        }
    }

    private void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }

}
