package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ASK_TRY_COUNT = "시도할 횟수는 몇 회인가요?";
    private static final Scanner SCANNER = new Scanner(System.in);

    public String inputCarNames() {
        System.out.println(INPUT_GUIDE_MESSAGE);

        return SCANNER.nextLine();
    }

    public int inputTryCount() {
        System.out.println(ASK_TRY_COUNT);

        return SCANNER.nextInt();
    }
}
