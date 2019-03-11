package calculator;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    static int result;

    static void input() {
        System.out.println("문자열을 입력하세요.");
        try (Scanner scanner = new Scanner(System.in)) {
            result = convertToExpressionUnit(scanner.nextLine());
        }
    }

    static void validate(String[] values) {
        if (values.length < 3) {
            throw new RuntimeException("계산할 수 없는 문자열입니다.");
        }
    }

    static int convertToExpressionUnit(String text) {
        String[] values = text.split(" ");
        validate(values);

        int prev, post;
        prev = parseInt(values[0]);
        for (int i = 0; i < values.length - 2; i += 2) {
            post = parseInt(values[i + 2]);
            prev = calculate(prev, values[i + 1], post);
        }
        return prev;
    }

    static int calculate(int prev, String operator, int post) {
        return Operation.fromString(operator)
                .apply(prev, post);
    }

    static void output() {
        System.out.println(result);
    }
}

