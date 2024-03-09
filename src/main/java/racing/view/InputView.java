package racing.view;

import racing.enums.RacingQuestionEnum;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public int inputNumber(String keyword) {
        printQuestion(keyword);
        int number = getPositiveNumberInput();
        return number;
    }

    private void printQuestion(String keyword) {
        String question = RacingQuestionEnum.getQuestionByKeyword(keyword);
        System.out.println(question);
    }

    private int getPositiveNumberInput() {
        int number;

        while (true) {
            acceptOnlyNumber();
            number = scanner.nextInt();
            if (isPositive(number)) {
                break;
            }
            System.out.println("양수만 입력해 주시길 바랍니다.");
        }

        return number;
    }

    private void acceptOnlyNumber() {
        while (!scanner.hasNextInt()) {
            System.out.println("0을 초과하는 숫자만 입력해 주시길 바랍니다.");
            scanner.next();
        }
    }

    private boolean isPositive(int number) {
        return number > 0;
    }
}
