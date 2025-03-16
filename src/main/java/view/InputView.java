package view;

import java.util.Scanner;

public class InputView {
    public static int read(String question) {
        System.out.println(question);
        return readPositiveInteger();
    }

    private static int readPositiveInteger() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        try {
            return toInteger(value);
        } catch (NumberFormatException e) {
            System.out.println("0보다 큰 양의 정수를 입력해주세요. 입력값=" + value);
            return readPositiveInteger(); // 재귀 호출로 다시 입력 요청
        }
    }

    private static int toInteger(String value) {
        int result = Integer.parseInt(value);
        if (result <= 0) {
            throw new NumberFormatException();
        }
        return result;
    }
}
