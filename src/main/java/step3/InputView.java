package step3;

import java.util.Scanner;

public class InputView {

    public Rule input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        String carCountStr = scanner.nextLine();
        Integer carCount = getIntegerValue(carCountStr);

        System.out.println("시도할 회수는 몇 회 인가요?");
        String timeStr = scanner.nextLine();
        Integer time = getIntegerValue(timeStr);

        return Rule.from(carCount, time);
    }

    private Integer getIntegerValue(String input) {
        isValid(input);
        return Integer.valueOf(input);
    }

    public void isValid(String input) {
        InputValidator.isNullOrEmptyForString(input);
        InputValidator.isNumberForString(input);
    }
}
