package racingcar;

import java.util.Scanner;

public class InputView {

    public static String receiveCarNumber(Scanner scanner) {
        questionCarNumber();
        return scanner.nextLine();
    }

    public static int receiveTryNumber(Scanner scanner) {
        questionTryNumber();
        return scanner.nextInt();
    }

    private static void questionCarNumber() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    private static void questionTryNumber() {
        System.out.println("시도할 회수는 몇 회인가요?");
    }

}
