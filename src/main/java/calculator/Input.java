package calculator;


import java.util.Scanner;

public class Input {
    public static String mathQuiz() {
        System.out.println("문자열 계산식을 입력해주세요 :");
        Scanner scanner = new Scanner(System.in);
        String value = exchangeWhiteSpace(scanner.nextLine());
        validateBlank(value);
        return value;
    }

    private static String exchangeWhiteSpace(String input) {
        if (input.equals(" ")) {
            return input.replace(" ", "");
        }
        return input;
    }

    private static void validateBlank(String input) {
        if (input == null || input.equals("")) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
    }
}
