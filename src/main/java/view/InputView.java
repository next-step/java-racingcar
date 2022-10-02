package view;

import java.util.Objects;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String[] input() {
        return new String[]{inputString(), inputOperator()};
    }

    public static String inputString() {
        System.out.println("계산하고 싶은 문자열을 입력해 주세요.");
        return scanner.next();
    }

    public static String inputOperator() {
        System.out.println("계산하려는 연산 방법을 부호로 입력해 주세요.");
        String operator = scanner.next();

        if (Objects.isNull(operator) || operator.isEmpty()) {
            throw new RuntimeException("연산자가 누락되었습니다.");
        }

        return operator;
    }
}
