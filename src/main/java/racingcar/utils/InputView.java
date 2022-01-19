package racingcar.utils;

import java.util.Scanner;

public class InputView {

    private static final String GET_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static String getCarNames() {
        System.out.println(GET_NAME_MESSAGE);
        return SCANNER.nextLine();
    }
}
