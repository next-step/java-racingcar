package view;

import java.util.List;
import java.util.Scanner;

public class RaceView {
    private final Scanner scanner;

    public RaceView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int queryAndGetNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public int queryAndGetSteps() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public void printResultTitle() {
        System.out.println("실행 결과");
    }

    public void printCurrentRaceStatus(List<Integer> carPositions) {
        for (var carPosition : carPositions) {
            printCarPositionWithBars(carPosition);
            System.out.println();
        }
        System.out.println();
    }

    private void printCarPositionWithBars(int carPosition) {
        for (int i = 0; i <= carPosition; ++i) {
            System.out.print("-");
        }
    }
}
