package step5;

import java.util.Scanner;

public class GameInput {

    static Scanner scanner = new Scanner(System.in);

    public static int readRoundCount() {
        System.out.println("몇 번 시도할 것인가요?");
        int roundCount = scanner.nextInt();
        validateBiggerThan0(roundCount);
        return roundCount;
    }

    private static void validateBiggerThan0(int roundCount) {
        if (roundCount <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public static String[] readCarNames() {
        System.out.println("경주할 자동차의 이름을 입력하세요(이름은 쉼표 (,)를 기준으로 구분)");
        String names = scanner.nextLine();
        validateNames(names);
        return names.split(",");
    }

    private static void validateNames(String names) {
        validateNotNull(names);
        validateNotEmpty(names);
        validateNamesSizeNot0(names);
    }

    private static void validateNotNull(String names) {
        if (names == null) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNotEmpty(String names) {
        if (names.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNamesSizeNot0(String names) {
        if (names.split(",").length == 0) {
            throw new IllegalArgumentException();
        }
    }
}
