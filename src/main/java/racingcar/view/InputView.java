package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int getTurn() {
        int turn;

        System.out.println("시도할 횟수는 몇 회인가요?");
        turn = readInt();
        System.out.println();

        return turn;
    }

    private static int readInt() {
        return scanner.nextInt();
    }

    public static String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }
}
