package homework.week1;

import java.util.List;
import java.util.Scanner;

public class RacingCarGameFront {

    private static final String INPUT_CAR_NAME_GUIDE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_RACING_NUMBER_GUIDE = "시도할 회수는 몇회인가요?";
    private static final String RUN_SYMBOL = "-";

    String getInputCarStrs() {
        printGuideStr(INPUT_CAR_NAME_GUIDE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    int getInputNumberOfRacing() {
        printGuideStr(INPUT_RACING_NUMBER_GUIDE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    void printRunCar(int runCount) {
        for (int count = 0; count < runCount; count++) {
            System.out.print(RUN_SYMBOL);
        }
        printEmptyLine();
    }

    void printRacingCars(List<Integer> carsRunCount) {
        for (int runCount : carsRunCount) {
            printRunCar(runCount);
        }
        printEmptyLine();
    }

    void printGuideStr(String guideStr) {
        System.out.println(guideStr);
    }

    void printEmptyLine() {
        System.out.println();
    }

}
