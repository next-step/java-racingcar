package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final static int MAX_NAME_LENGTH = 5;
    private final static int MIN_NAME_COUNT = 2;
    private final static Scanner scanner = new Scanner(System.in);

    public static int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = scanner.nextLine();

        validateTryCount(input);

        return Integer.parseInt(input);
    }

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        List<String> carNames = Arrays.asList(scanner.nextLine().split(","));
        validateCarNameCount(carNames);

        for (String carName : carNames) {
            validateCarNameLength(carName);
        }
        return carNames;
    }

    public static void validateTryCount(String tryCount) {
        if (tryCount.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 횟수는 공백일 수 없습니다.");
        }

        if (!tryCount.matches("[0-9]")) {
            throw new IllegalArgumentException("[ERROR] 횟수는 숫자만 허용합니다.");
        }
    }

    public static void validateCarNameCount(List<String> carNames) {
        if (carNames.size() < MIN_NAME_COUNT) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 2개 이상이어야 합니다.");
        }
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}
