package racing.views;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String CAR_NAMES_Q = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String NUMBER_Q = "시도할 회수는 몇 회 인가요?";

    private final Scanner scanner;

    public InputView () {
        this.scanner = new Scanner(System.in);
    }

    public String inputString(String description) {
        System.out.println(description);
        String value = scanner.nextLine();
        validation(value);
        return value;
    }

    public List<String> getNames() {
        return Arrays.asList(inputString(CAR_NAMES_Q).split(","));
    }

    public int getNumberOfAttempts() {
        return toInteger(inputString(NUMBER_Q));
    }

    public void validation(String x) {
        if (isBlank(x))
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
    }

    public static int toInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("정수만 입력이 가능합니다.");
        }
    }

    public static boolean isBlank(String value) {
        return "".equals(value.trim());
    }
}
