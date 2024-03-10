package racing.view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public int inputNumber(String question) {
        System.out.println(question);
        int number = getPositiveNumberInput();
        return number;
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
