package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static void printInputUsername() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public static int receiveTryCount() {
        return scanner.nextInt();
    }

    public static String[] receiveNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.next().split(",");
    }

    public static void close() {
        scanner.close();
    }
}

