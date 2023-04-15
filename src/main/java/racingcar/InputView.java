package racingcar;

import java.util.Scanner;

public class InputView {

    public static int receiveCarNumber(Scanner scanner) {
        questionCarNumber();
        return scanner.nextInt();
    }

    public static int receiveTryNumber(Scanner scanner) {
        questionTryNumber();
        return scanner.nextInt();
    }

    private static void questionCarNumber() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    private static void questionTryNumber() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

}
