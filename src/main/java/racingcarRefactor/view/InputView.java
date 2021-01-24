package racingcarRefactor.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    private static String INPUT_INFO_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static String LAP_INFO_MESSAGE = "시도할 횟수를 입력해주세요";

    public static String inputCarNames() {
        System.out.println(INPUT_INFO_MESSAGE);
        return scanner.nextLine();
    }

    public static int inputTotalLaps() {
        System.out.println(LAP_INFO_MESSAGE);
        return scanner.nextInt();
    }
}
