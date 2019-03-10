package calculator;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    static String[] values;
    static int result;

    static void input() {
        System.out.println("문자열을 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        result = calculate(scanner.nextLine());
    }

    static void validate(String[] values) {
        if (values.length < 3)
            System.out.println("계산할 수 없는 문자열입니다.");
    }

    static int calculate(String text) {
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
        switch (operator) {
            case "+":
                return prev + post;
            case "-":
                return prev - post;
            case "*":
                return prev * post;
            case "/":
                return prev / post;
            default:
                System.out.println("존재하지 않는 사칙연산 기호입니다.");
        }
        return 0;
    }

    static void output() {
        System.out.println(result);
    }
}

