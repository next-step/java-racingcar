package step5.view;

import java.util.Scanner;

public class GameInput {

    private static final Scanner scanner = new Scanner(System.in);

    public static int readRoundCount() {
        System.out.println("몇 번 시도할 것인가요?");
        int roundCount = scanner.nextInt();
        validateBiggerThan0(roundCount);
        return roundCount;
    }

    private static void validateBiggerThan0(int roundCount) {
        if (roundCount <= 0) {
            throw new IllegalArgumentException("라운드 수는 0보다 작을 수 없습니다.");
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
        validateNamesSizeNot0(names);
    }

    private static void validateNotNull(String names) {
        if (names == null || names.trim().length() == 0) {
            throw new IllegalArgumentException("입력이 비어있을 수 없습니다.");
        }
    }

    private static void validateNamesSizeNot0(String names) {
        if (names.split(",").length == 0) {
            throw new IllegalArgumentException();
        }
    }
}
