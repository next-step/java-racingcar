package racingcar;

import java.util.Scanner;

public class InputView {
    public static int getCarNumber() {
        printIntroMessage("자동차 대수는 몇 대 인가요?");
        return getUserInput();
    }

    public static int getRoundNumber() {
        printIntroMessage("시도할 회수는 몇 회인가요?");
        return getUserInput();
    }

    private static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void printIntroMessage(String message) {
        System.out.println(message);
    }
}
