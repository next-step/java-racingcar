package racingcar.view;

import java.util.Objects;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String inputNumberOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        String numberOfCar = scanner.nextLine();

        validateNullOrEmpty(numberOfCar);

        return numberOfCar;
    }

    public static String inputNumberOfPhase() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        String numberOfPhase = scanner.nextLine();

        validateNullOrEmpty(numberOfPhase);

        return numberOfPhase;
    }

    private static void validateNullOrEmpty(String inputString) {
        if (Objects.isNull(inputString) || inputString.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값은 Null 또는 빈 문자열이 될 수 없습니다.");
        }
    }
}
