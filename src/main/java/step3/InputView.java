package step3;

import java.util.Scanner;

public class InputView {

    public Rule input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        String carCountStr = scanner.nextLine();
        Long carCount = getLongValue(carCountStr);

        System.out.println("시도할 회수는 몇 회 인가요?");
        String timeStr = scanner.nextLine();
        Long time = getLongValue(timeStr);

        return Rule.from(carCount, time);
    }

    private Long getLongValue(String input) {
        isValid(input);
        return Long.valueOf(input);
    }

    public void isValid(String input) {
        InputValidator.isNullOrEmptyForString(input);
        InputValidator.isNumberForString(input);
    }
}
