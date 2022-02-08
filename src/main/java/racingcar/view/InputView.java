package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final static int MAX_NAME_LENGTH = 5;

    private static void validateCarNameLength(String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public static int getTryCount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("시도할 횟수는 몇 회인가요?");

        return Integer.parseInt(scanner.nextLine());
    }

    public static List<String> getCarNames() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        List<String> carNames = Arrays.asList(scanner.nextLine().split(","));

        for (String carName : carNames) {
            validateCarNameLength(carName);
        }
        return carNames;
    }
}
