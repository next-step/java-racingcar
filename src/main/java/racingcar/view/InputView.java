package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getIntegerValue(String question) {
        System.out.print(question);
        readInteger();
        return scanner.nextInt();
    }

    public static String[] getStringArray(String question, String regex) {
        System.out.println(question);
        readString();
        String str = scanner.nextLine();
        return str.split(regex);
    }

    private static void readInteger() {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.err.print("숫자를 입력하세요> ");
        }
    }

    private static void readString() {
        while (!scanner.hasNext()) {
            scanner.next();
            System.err.print("자동차 이름 입력하세요> ");
        }
    }
}
