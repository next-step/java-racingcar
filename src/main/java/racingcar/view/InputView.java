package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String SEPERATOR = ",";

    public static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = scanner.nextLine().split(SEPERATOR);

        for(String name : carNames) {
            validateCarName(name);
        }

        return Arrays.asList(carNames);
    }

    private static void validateCarName(String input) {
        if (Objects.isNull(input) || input.isEmpty() || input.length() > 5) {
            throw new RuntimeException("올바르지 않은 값입니다.");
        }
    }

    public static int inputTryNumber() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryNumber = scanner.nextInt();

        validateTryNumber(tryNumber);

        return tryNumber;
    }

    private static void validateTryNumber(int input) {
        if (input < 0) {
            throw new RuntimeException("올바르지 않은 값입니다.");
        }
    }
}
