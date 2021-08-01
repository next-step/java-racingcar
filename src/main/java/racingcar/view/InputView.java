package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String receiveCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public static int receiveRoundCount() {
        String input;
        System.out.println("시도할 회수는 몇 회 인가요?");
        do {
            input = scanner.nextLine();
        } while (!isNumber(input));
        return Integer.parseInt(input);
    }

    private static boolean isNumber(String input) {
        if (input == null || !input.chars().allMatch(Character::isDigit)) {
            System.out.println("숫자만 입력 가능합니다.");
            return false;
        }
        return true;
    }
}
