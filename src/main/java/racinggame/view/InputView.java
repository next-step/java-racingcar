package racinggame.view;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static List<String> cars() {
        String carNames;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            carNames = scanner.nextLine();
        } while (!isValidCarNames(carNames));
        return Arrays.asList(carNames.split(","));
    }

    private static boolean isValidCarNames(String carNames) {
        if (Objects.isNull(carNames) || carNames.isEmpty()) {
            System.out.println("1대 이상 입력해주세요.");
            return false;
        }
        return true;
    }

    public static int rounds() {
        String roundString;
        do {
            System.out.println("시도할 회수는 몇 회 인가요?");
            roundString = scanner.nextLine();
        } while (!isValidRounds(roundString));
        return Integer.parseInt(roundString);
    }

    private static boolean isValidRounds(String roundString) {
        try {
            int rounds = Integer.parseInt(roundString);
            return isGreaterThan0(rounds);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해 주세요.");
            return false;
        }
    }

    private static boolean isGreaterThan0(int rounds) {
        if (rounds < 1) {
            System.out.println("1이상의 숫자를 입력해 주세요");
            return false;
        }
        return true;
    }
}
