package step3;

import com.sun.tools.javac.util.StringUtils;

import java.util.Scanner;

public class InputView {
    private final static String NUMBER_PATTERN = "\\d*$";

    public void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        String carCountStr = scanner.nextLine();
        Long carCount = getLongValue(carCountStr);

        System.out.println("시도할 회수는 몇 회 인가요?");
        String timeStr = scanner.nextLine();
        Long time = getLongValue(timeStr);
    }

    private Long getLongValue(String input) {
        isValid(input);
        return Long.valueOf(input);
    }

    public void isValid(String input) {
        if(input == null || input.length() == 0) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
        if(!input.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException("입력 값이 숫자가 아닙니다.");
        }
    }
}
