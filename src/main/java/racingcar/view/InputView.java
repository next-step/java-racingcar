package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int getCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return CountParser.parse(SCANNER.nextLine());
    }

    public static int getRoundCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return CountParser.parse(SCANNER.nextLine());
    }
}
