package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_NAME_OF_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_ROUND_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] inputCarName() {
        System.out.println(INPUT_NAME_OF_CAR_MESSAGE);
        return names(scanner.nextLine());
    }

    public static int inputRoundNumber() {
        System.out.println(INPUT_ROUND_MESSAGE);
        return scanner.nextInt();
    }

    public static String[] names(String input) {
        return input.split(",");
    }
}
