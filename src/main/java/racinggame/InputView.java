package racinggame;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = SCANNER.nextLine().split(StringConstants.COMMA);
        return List.of(carNames);
    }

    public static int inputTryCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return inputPositiveNumber();
    }

    private static int inputPositiveNumber() {
        int num = SCANNER.nextInt();
        if (num <= 0) {
            throw new RuntimeException("0 또는 음수는 전달할 수 없습니다.");
        }
        return num;
    }

}
