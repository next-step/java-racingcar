package view;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RaceView {
    private final Scanner scanner;

    public RaceView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> queryAndGetNamesOfCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        var input = scanner.nextLine();
        return Arrays.asList(input.split(","));
    }

    public int queryAndGetSteps() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public void printResultTitle() {
        System.out.println("실행 결과");
    }

    public void printCurrentRaceStatus(Map<String, Integer> carPositions) {
        for (var entry : carPositions.entrySet()) {
            printCarPositionWithBars(entry.getKey(), entry.getValue());
            System.out.println();
        }
        System.out.println();
    }

    private void printCarPositionWithBars(String carName, int carPosition) {
        System.out.print(carName + " : ");
        for (int i = 0; i <= carPosition; ++i) {
            System.out.print("-");
        }
    }
}
