package ui;

import java.util.Scanner;

public class InputView {
    public static String getNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        return validationInput(scanner.nextLine());
    }

    public static int getTryCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static String validationInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
        return input;
    }

}
