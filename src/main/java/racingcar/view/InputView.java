package racingcar.view;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Pattern pattern = Pattern.compile("^[1-9]*$");

    public static int receiveCarCount() {
        String input;
        do {
            System.out.println("자동차 대수는 몇 대 인가요?");
            input = scanner.nextLine();
        } while (!isNumberMoreThanZero(input));
        return Integer.parseInt(input);
    }

    public static int receiveRoundCount() {
        String input;
        do {
            System.out.println("시도할 회수는 몇 회 인가요?");
            input = scanner.nextLine();
        } while (!isNumberMoreThanZero(input));
        return Integer.parseInt(input);
    }

    private static boolean isNumberMoreThanZero(String input) {
        if (!pattern.matcher(input).find()) {
            System.out.println("1이상 숫자만 입력 가능합니다.");
            return false;
        }
        return true;
    }
}
