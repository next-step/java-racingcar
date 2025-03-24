package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] getNameOfCars() {
        String input_string = getInputString("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return input_string.split(",");
    }

    public static int getNumberOfRounds() {
        return getInputInt("시도할 회수는 몇 회 인가요?");
    }

    private static String getInputString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    private static int getInputInt(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }
}