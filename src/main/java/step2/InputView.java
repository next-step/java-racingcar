package step2;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    static int inputCarNumber() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    static int inputExecuteNumber() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

}
