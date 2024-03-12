package racingcar.ui;

import java.util.Scanner;

public class InputView {

    private final static Scanner SCANNER = new Scanner(System.in);

    private InputView() {

    }

    public static int readHowManyCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return readInt();
    }

    public static int readHowManyTrys() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return readInt();
    }

    private static int readInt() {
        return SCANNER.nextInt();
    }

}
