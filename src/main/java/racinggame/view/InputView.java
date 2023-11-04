package racinggame.view;

import static java.lang.System.out;

import java.util.Scanner;

public class InputView {

    private InputView() {
    }

    public static final String DELIMITER = ",";

    public static String[] carNames(Scanner scanner) {
        out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();

        return input.split(DELIMITER);
    }

    public static int playCount(Scanner scanner) {
        out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

}
