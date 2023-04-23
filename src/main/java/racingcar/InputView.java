package racingcar;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public int requestCarNums() {
        System.out.println("자동차 대수는 몇 대인가요?");
        return SCANNER.nextInt();
    }

    public int requestMoveNums() {
        System.out.println("시도할 회수는 몇 회인가요?");
        return SCANNER.nextInt();
    }
}