package calculator;


import java.util.Scanner;

public class Input {
    public String mathQuiz() {
        System.out.println("문자열 계산식을 입력해주세요 :");
        Scanner scanner = new Scanner(System.in);
        return exchangeWhiteSpace(scanner.nextLine());
    }

    private String exchangeWhiteSpace(String input) {
        if (input.equals(" ")) {
            return input.replace(" ", "");
        }
        return input;
    }
}
