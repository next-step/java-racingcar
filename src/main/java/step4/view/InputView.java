package step4.view;

import step4.domain.UserInput;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static UserInput input() {
        final String names = inputCarNames();
        final int retry = inputRetryCount();

        return new UserInput(names, retry);
    }

    private static String inputCarNames() {
        System.out.println("경주할 자동 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        return SCANNER.nextLine();
    }

    private static int inputRetryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");

        return SCANNER.nextInt();
    }

}
