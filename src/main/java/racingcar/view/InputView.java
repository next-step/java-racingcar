package racingcar.view;

import java.util.Scanner;

public class InputView {

    public static final String CAR_NAME_SEPARATOR = ",";

    private static final Scanner scanner = new Scanner(System.in);

    public static String[] getCarNames() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return nextLine().split(CAR_NAME_SEPARATOR);
    }

    public static int getPlayCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return nextInt();
    }

    public static int nextInt() {
        return scanner.nextInt();
    }

    public static String nextLine() {
        return scanner.nextLine();
    }

}
