package racinggame.view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String SPLIT_NAME_TEXT = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> carNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return Arrays.asList(scanner.nextLine().split(SPLIT_NAME_TEXT));
    }

    public static int gameCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("숫자로 입력해주세요.");
        }
    }
}
