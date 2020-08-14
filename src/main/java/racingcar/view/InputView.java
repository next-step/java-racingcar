package racingcar.view;

import racingcar.constant.Constant;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String[] inputCarName() {
        System.out.println(Constant.INPUT_NAME_OF_CAR_MESSAGE);
        return names(scanner.nextLine());
    }

    public static int inputRoundNumber() {
        System.out.println(Constant.INPUT_ROUND_MESSAGE);
        return scanner.nextInt();
    }

    public static String[] names(String input) {
        return input.split(Constant.COMMA);
    }
}
